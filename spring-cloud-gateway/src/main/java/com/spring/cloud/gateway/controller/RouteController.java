package com.spring.cloud.gateway.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring.cloud.gateway.repository.MysqlRouteDefinitionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2019/12/24 15:44
 */
@RequestMapping("/route")
@RestController
public class RouteController {
    private static final Logger logger = LoggerFactory.getLogger(RouteController.class);

    @Autowired
    private MysqlRouteDefinitionRepository mysqlRouteDefinitionRepository;

    /**
     * 新增路由
     *
     * 开启SSL会导致post方法无法执行
     * 原因： Postman 中关闭以下设置
     * File -> setting -> General 中的 SSL certificate verification
     *
     * @param routeJsonObject
     * @return
     */
    @RequestMapping("/save")
    public String save(@RequestBody JSONObject routeJsonObject){
        logger.debug("routeJsonObject ===: {}", JSONObject.toJSONString(routeJsonObject));

        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(routeJsonObject.getString("id"));

        List<PredicateDefinition> predicates = new ArrayList<>();
        PredicateDefinition predicateDefinition = new PredicateDefinition(routeJsonObject.getString("path"));
        predicates.add(predicateDefinition);
        routeDefinition.setPredicates(predicates);

        List<FilterDefinition> filters = new ArrayList<>();
        FilterDefinition filterDefinition = new FilterDefinition("StripPrefix=1");
        filters.add(filterDefinition);
        routeDefinition.setFilters(filters);

        routeDefinition.setUri(URI.create(routeJsonObject.getString("uri")));

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("response-timeout", 200);
        metadata.put("connect-timeout", 200);
        routeDefinition.setMetadata(metadata);

        mysqlRouteDefinitionRepository.save(routeDefinition);

        return "save successfully";
    }

    /**
     * 删除路由
     *
     * @param routeId
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam String routeId){

        mysqlRouteDefinitionRepository.delete(routeId);

        return "delete successfully";
    }
}
