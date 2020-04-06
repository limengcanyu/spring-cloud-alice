package com.spring.cloud.storage.microservice.dao.entity;

import lombok.Data;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/06 09:26
 */
@Data
public class Storage {
    private Integer id;

    private String commodityCode;

    private Integer count;

}
