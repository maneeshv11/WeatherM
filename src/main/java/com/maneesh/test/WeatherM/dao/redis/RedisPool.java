package com.maneesh.test.WeatherM.dao.redis;

import com.maneesh.test.WeatherM.constant.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


@Component
public class RedisPool {
    private static Jedis jedis = null;

    @Autowired
    private PropertiesConfig propertiesConfig;

    public static Jedis getInstance(){
        if (jedis != null){
            return jedis;
        }else{
            synchronized (RedisPool.class){
                if (jedis == null){
                    jedis = new Jedis("127.0.0.1", 6379);
                }
            }
        }
        return jedis;
    }
}
