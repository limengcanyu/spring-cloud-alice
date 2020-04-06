package com.spring.cloud.storage.microservice.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.storage.microservice.dao.entity.Storage;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2020/04/06 09:27
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

}
