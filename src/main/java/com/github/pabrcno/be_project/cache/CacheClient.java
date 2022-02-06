package com.github.pabrcno.be_project.cache;

import java.time.Duration;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheClient<T> implements ICacheClient<T> {

    private final RedisTemplate<String, T> redisTemplate;
    private HashOperations<String, String, String> hashOperations;
    private final ObjectMapper mapper;


    @PostConstruct
    void setHashOperations() {
        hashOperations = redisTemplate.opsForHash();
        this.redisTemplate.expire("map", Duration.ofMillis(60000));
    }



    @Override
    public T save(String key, T data) {
        try {
            hashOperations.put("", key, serializeItem(data));
            return data;
        } catch (JsonProcessingException e) {
            log.error("Error converting message to string", e);
        }
        return data;
    }

    @Override
    public T recover(String key, Class<T> classValue) {
        try {
            var item = hashOperations.get("map", key);
            if (item == null) return null;
            return deserializeItem(item, classValue);
        } catch (JsonProcessingException e) {
            log.error("Error converting message to Message", e);
        }
        return null;
    }

    private String serializeItem(T item) throws JsonProcessingException {
        var serializeItem = mapper.writeValueAsString(item);
        log.info("Mensaje en formato String: {}", serializeItem);
        return serializeItem;
    }

    private T deserializeItem(String jsonInput, Class<T> classValue) throws JsonProcessingException {
        return mapper.readValue(jsonInput, classValue);
    }


    @Override
    public void delete(String key) {
        hashOperations.delete("", key);
    }

    @Override
    public T update(String key, T value) {
            delete(key);
            return save(key, value);
    }



}
