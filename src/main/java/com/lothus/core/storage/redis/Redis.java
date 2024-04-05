package com.lothus.core.storage.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.RedisPubSubListener;
import lombok.Getter;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

public abstract class Redis {

    public abstract String get(String key);

    public abstract void set(String key, String value);
    public abstract void del(String key);

    public abstract void subscribe(JedisPubSub jedisPubSub, String... channels);
    public abstract void subscribe(RedisPubSubListener<String, String> listener, String... channels);

    public abstract void message(String channel, String message);

    public abstract JedisPool getPool();
    public abstract RedisClient getClient();

    public abstract void start(String host, int port, String password);
    public abstract void shutdown();
}
