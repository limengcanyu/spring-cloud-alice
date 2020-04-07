package com.spring.cloud.order.microservice.dao.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Rock
 * @since 2020-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderTbl implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;


}
