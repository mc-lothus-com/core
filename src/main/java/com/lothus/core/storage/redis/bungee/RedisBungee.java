package com.lothus.core.storage.redis.bungee;

import com.lothus.core.Core;
import com.lothus.core.storage.redis.Redis;
import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.RedisPubSubListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class RedisBungee extends Redis {

    @Getter
    private JedisPool pool;

    public void start(String hostname, int port, String password) {
        if (!password.isEmpty())
            pool = new JedisPool(new JedisPoolConfig(), hostname, port, 0, password);
        else {
            pool = new JedisPool(new JedisPoolConfig(), hostname, port, 0);
        }
    }

    public String get(String key) {
        try (Jedis j = this.pool.getResource()) {
            return j.get(key);
        }
    }

    public void set(String key, String value) {
        try (Jedis j = this.pool.getResource()) {
            j.set(key, value);
        }
    }

    public void del(String key) {
        try (Jedis j = this.pool.getResource()) {
            j.del(key);
        }
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        new Thread(new PubSubTask(jedisPubSub, channels)).start();
    }

    @Override
    public void subscribe(RedisPubSubListener<String, String> listener, String... channels) {

    }

    public void message(String channel, String message) {
        try (Jedis j = this.pool.getResource()) {
            j.publish(channel, message);
        }
    }

    @Override
    public RedisClient getClient() {
        return null;
    }

    public void shutdown() {
        if (this.pool != null) {
            this.pool.close();
        }
    }

    public boolean isConnected() {
        return this.pool != null && !this.pool.isClosed();
    }

    public static class PubSubTask implements Runnable {

        private final JedisPubSub jpsh;
        private final String[] channels;

        public PubSubTask(JedisPubSub s, String... channels) {
            this.jpsh = s;
            this.channels = channels;
        }

        @Override
        public void run() {
            boolean broken = false;
            try (Jedis rsc = Core.getRedis().getPool().getResource()) {
                try {
                    rsc.subscribe(jpsh, channels);
                } catch (Throwable e) {
                    e.printStackTrace();
                    try {
                        jpsh.unsubscribe();
                    } catch (Throwable e1) {
                    }
                    broken = true;
                }
            }
            if (broken) {
                run();
            }
        }

        public void addChannel(String... channel) {
            jpsh.subscribe(channel);
        }

        public void removeChannel(String... channel) {
            jpsh.unsubscribe(channel);
        }

        public void poison() {
            jpsh.unsubscribe();
        }
    }
}
