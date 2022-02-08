package com.github.pabrcno.be_project.cache;

public interface ICacheClient<T> {
    T save(String key, T value);
    T recover(String key, Class<T> clazz);
    void delete(String key);
    T update(String key, T value);
}
    
