package com.spring.cloud.order.microservice.service.impl;

import com.spring.cloud.order.microservice.dao.entity.OrderTbl;
import com.spring.cloud.order.microservice.dao.mapper.OrderTblMapper;
import com.spring.cloud.order.microservice.service.IOrderTblService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rock
 * @since 2020-04-07
 */
@Service
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl> implements IOrderTblService {

}
