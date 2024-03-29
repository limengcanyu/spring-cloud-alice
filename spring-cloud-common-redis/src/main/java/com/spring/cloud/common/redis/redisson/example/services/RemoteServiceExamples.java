/**
 * Copyright (c) 2016-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spring.cloud.common.redis.redisson.example.services;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

public class RemoteServiceExamples {
    
    public interface RemoteInterface {
        
        Long myMethod(Long value);
        
    }
    
    public static class RemoteImpl implements RemoteInterface {

        public RemoteImpl() {
        }
        
        @Override
        public Long myMethod(Long value) {
            return value*2;
        }

    }

    public static void main(String[] args) {
        // connects to 127.0.0.1:6379 by default
        RedissonClient server = Redisson.create();
        RedissonClient client = Redisson.create();
        try {
            server.getRemoteService().register(RemoteInterface.class, new RemoteImpl());

            RemoteInterface service = client.getRemoteService().get(RemoteInterface.class);

            service.myMethod(21L);

        } finally {
            client.shutdown();
            server.shutdown();
        }

    }
    
}
