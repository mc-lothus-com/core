package com.lothus.core.storage.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoStorage {

    private MongoClient client;

    public void start(String host, int port) {
        client = new MongoClient(host,port);
    }

    public void stop() {
        client.close();
    }

    public MongoDatabase getDatabase(String data) {
        return client.getDatabase(data);
    }
}
