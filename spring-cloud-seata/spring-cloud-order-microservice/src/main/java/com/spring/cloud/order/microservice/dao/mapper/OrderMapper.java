package com.spring.cloud.order.microservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.order.microservice.dao.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/06 09:22
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
