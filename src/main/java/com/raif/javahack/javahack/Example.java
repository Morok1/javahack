package com.raif.javahack.javahack;


import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class Example {

    @Resource(name = "redisTemplate")
    private SetOperations<String, String> setOps;

    public void setProducerList(String consumerCategory, String[] producerList) {
//        setOps.add(consumerCategory, producerList);
        setOps.add(consumerCategory, producerList);
    }

    public Set<String> getProducerList(String key) {
        Set<String> set = setOps.members(key);
        if (set == null){
            return new HashSet<String>();
        }
        for (String str : set) {
            System.out.println(str);
        }
        return set;
    }


}


