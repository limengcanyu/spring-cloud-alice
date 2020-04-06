package com.spring.cloud.account.microservice.dao.entity;

import lombok.Data;
import java.math.BigDecimal;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/06 09:14
 */

@Data
public class Account {
    private Integer id;

    private String userId;

    private BigDecimal money;

}
