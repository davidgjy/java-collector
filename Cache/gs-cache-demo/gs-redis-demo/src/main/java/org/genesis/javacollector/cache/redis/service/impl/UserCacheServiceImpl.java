package org.genesis.javacollector.cache.redis.service.impl;

import org.genesis.javacollector.cache.redis.service.MockService;
import org.genesis.javacollector.cache.redis.service.UserCacheService;
import org.genesis.javacollector.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: KG
 * @description:
 * @date: Created in 下午4:42 2019/7/13
 * @modified by:
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MockService mockService;

//    @Autowired(required = false)
//    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//
//        this.redisTemplate = redisTemplate;
//    }

    @Override
    public List<String> getUsersFromCache() {

        List<String> users = new ArrayList<>();

        for (int i=1;i<=1000;i++) {
            String user = (String)redisTemplate.opsForValue().get(String.valueOf(i));
            users.add(user);
        }

        // the object is null
//        List<Object> results = redisTemplate.executePipelined(
//                new RedisCallback<Object>() {
//                    @Override
//                    public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                        StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
//                        for(int i=1; i<= 1000; i++) {
//                            String user = stringRedisConn.get(String.valueOf(i));
//                            users.add(user);
//                        }
//                        return null;
//                    }
//                });

        return users;
    }

    @Override
    public void setUsersToCahce() {
        List<User> users = mockService.mockUsers(1000);

        List<Object> redisResult = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                for (User user : users) {
                    StringRedisConnection stringRedisConnection = (StringRedisConnection) redisConnection;
                    stringRedisConnection.set(String.format("%d", user.getId()), user.toString());
                }
                return null;
            }
        });
    }
}
