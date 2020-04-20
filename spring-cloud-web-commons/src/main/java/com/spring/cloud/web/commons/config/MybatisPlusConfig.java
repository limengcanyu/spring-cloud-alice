package com.spring.cloud.web.commons.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.spring.cloud.commons.utils.ContextUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.statement.delete.Delete;
import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/20 20:14
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // 分页插件 ===========================================================================
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));

        // 攻击 SQL 阻断解析器 =================================================================
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链
        sqlParserList.add(new BlockAttackSqlParser() {
            @Override
            public void processDelete(Delete delete) {
                // 如果你想自定义做点什么，可以重写父类方法像这样子
                if ("user".equals(delete.getTable().getName())) {
                    // 自定义跳过某个表，其他关联表可以调用 delete.getTables() 判断
                    return;
                }
                super.processDelete(delete);
            }
        });

        // 多租户 SQL 解析器 ===================================================================
        /*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId(boolean where) {
                // 该 where 条件 3.2.0 版本开始添加的，用于分区是否为在 where 条件中使用
                // 如果是in/between之类的多个tenantId的情况，参考下方示例
                return new StringValue(Objects.requireNonNull(ContextUtils.getTenantId()));
            }

            @Override
            public String getTenantIdColumn() {
                return "tenant_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                // 这里可以判断是否过滤表
            /*
            if ("user".equals(tableName)) {
                return true;
            }*/
                return false;
            }
        });
        sqlParserList.add(tenantSqlParser);

        paginationInterceptor.setSqlParserList(sqlParserList);

        paginationInterceptor.setSqlParserFilter(metaObject -> {
            MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
            // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
            return "com.baomidou.springboot.mapper.UserMapper.selectListBySQL".equals(ms.getId());
        });

        return paginationInterceptor;
    }

    /**
     * 乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
