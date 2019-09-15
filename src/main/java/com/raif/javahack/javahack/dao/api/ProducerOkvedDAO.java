package com.raif.javahack.javahack.dao.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProducerOkvedDAO {

    @Qualifier("redisProducersTemplate")
    @Resource(name = "redisConsumersTemplate")
    private SetOperations<String, String> setOps;

    @Autowired
    @Qualifier("redisProducersTemplate")
    private RedisTemplate<String, Object> redisProducersTemplate;


    public void setProducerList(String consumerCategory, String[] producerList) {
        redisProducersTemplate.opsForSet().add(consumerCategory, producerList);
    }

    public Set<Long> getProducerList(String key) {
        if (redisProducersTemplate.hasKey(key)) {
            Set<Long> set = redisProducersTemplate.opsForSet().members(key)
                                                    .stream()
                                                    .map(obj -> (Long) obj).collect(Collectors.toSet());
            for (Long str : set) {
                System.out.println(str);
            }
            return set;
        } else {
            return new HashSet<>();
        }

    }


}


