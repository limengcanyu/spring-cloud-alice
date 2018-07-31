package com.spring.cloud.eureka.product.clients.service;

import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/24 0024
 */
public interface StoreIntegrationService {
    Object getStores(Map<String, Object> parameters);
}
