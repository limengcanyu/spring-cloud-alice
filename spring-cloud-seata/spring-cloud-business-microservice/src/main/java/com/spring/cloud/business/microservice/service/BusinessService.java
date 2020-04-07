package com.spring.cloud.business.microservice.service;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/04 21:50
 */

public interface BusinessService {

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    void purchase(String userId, String commodityCode, int orderCount);

    void initData();

}
