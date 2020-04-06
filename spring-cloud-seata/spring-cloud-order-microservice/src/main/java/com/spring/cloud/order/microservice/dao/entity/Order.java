package com.spring.cloud.order.microservice.dao.entity;

import lombok.Data;
import java.math.BigDecimal;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/06 09:21
 */
@Data
public class Order {
    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private BigDecimal money;

}
