package com.lothus.core.storage.redis.bukkit;

import com.lothus.core.storage.redis.Redis;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.pubsub.RedisPubSubListener;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import lombok.Getter;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.concurrent.atomic.AtomicReference;

public class RedisBukkit extends Redis {

    @Getter
    private RedisClient client;
    private StatefulRedisPubSubConnection<String, String> con;

    public void start(String host, int port, String password) {
        client = RedisClient.create("redis://" + password + "@" + host + ":" + port + "/3");
    }

    public void subscribe(RedisPubSubListener<String, String> listener, String... channels) {
        con = client.connectPubSub();
        con.addListener(listener);
        con.async().subscribe(channels);
    }

    public void shutdown() {
        con.closeAsync();
        client.shutdown();
    }

    public void message(String channel, String packet) {
        StatefulRedisPubSubConnection<String, String> connection = client.connectPubSub();
        RedisAsyncCommands<String, String> pubSubCommands = connection.async();
        pubSubCommands.publish(channel, packet);
        connection.closeAsync();
    }

    @Override
    public JedisPool getPool() {
            return null;
    }

    public void set(String key, String value) {
        RedisAsyncCommands<String, String> async = client.connect().async();
        async.set(key, value);
    }

    public void del(String key) {
        RedisAsyncCommands<String,String> async = client.connect().async();
        async.del(key);
    }

    public String get(String key) {
        RedisAsyncCommands<String, String> async = client.connect().async();
        AtomicReference<String> value = new AtomicReference<>();
        async.get(key).whenComplete((s, throwable) -> {
            value.set(s);
        });
        return value.get();
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {

    }
}

