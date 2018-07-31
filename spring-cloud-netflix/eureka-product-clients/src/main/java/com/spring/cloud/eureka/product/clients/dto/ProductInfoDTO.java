package com.spring.cloud.eureka.product.clients.dto;

import lombok.Data;

/**
 * <p>Description: </p>
 *
 * @author Rock Jiang
 * @version 1.0
 * @date 2018/7/30 0030
 */
@Data
public class ProductInfoDTO {
    /**
     * 记录ID
     */
    private Long recordId;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 产品名称
     */
    private String productName;
}
