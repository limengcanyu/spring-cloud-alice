package com.spring.cloud.sleuth.service;

import com.spring.cloud.sleuth.SpringCloudSleuthApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * <p>Description: </p>
 *
 * @author rock.jiang
 * Date 2019/12/21 20:52
 */
@Service
public class HelloServiceImpl implements HelloService {
    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public void hello() {
        logger.info("hello service");
    }
}
