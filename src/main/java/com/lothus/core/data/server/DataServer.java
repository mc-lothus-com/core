package com.lothus.core.data.server;

import com.lothus.core.Core;
import com.lothus.core.servers.ServerInfo;
import com.lothus.core.servers.type.ServerType;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DataServer {

    private MongoCollection<Document> collection = Core.getMongo().getDatabase("core").getCollection("servers");

    public void create(ServerInfo serverInfo) {
        Document found = collection.find(Filters.eq("name", serverInfo.getName())).first();
        if (found == null) {
            found = Document.parse(Core.getGson().toJson(serverInfo));
            collection.insertOne(found);
        }
    }

    public void update(ServerInfo serverInfo) {
        Document found = collection.find(Filters.eq("name", serverInfo.getName())).first();
        if (found != null) {
            found = Document.parse(Core.getGson().toJson(serverInfo));
            collection.replaceOne(Filters.eq("name", serverInfo.getName()), found);
        }
        Core.getRedis().message("SERVER_UPDATE", Core.getGson().toJson(serverInfo));
    }

    public void delete(ServerInfo serverInfo) {
        Document found = collection.find(Filters.eq("name", serverInfo.getName())).first();
        if (found != null) {
            collection.deleteOne(Filters.eq("name", serverInfo.getName()));
        }
    }

    public ServerInfo get(String name) {
        Document found = collection.find(Filters.eq("name", name)).first();
        if (found != null) {
            return Core.getGson().fromJson(Core.getGson().toJson(found), ServerInfo.class);
        }
        return null;
    }


    public ServerInfo get(ServerType type) {
        Document found = collection.find(Filters.eq("type", type.name())).first();
        if (found != null) {
            return Core.getGson().fromJson(Core.getGson().toJson(found), ServerInfo.class);
        }
        return null;
    }


    public List<ServerInfo> getAll(ServerType type) {
        List<ServerInfo> all = new ArrayList<>();
        for (Document document : collection.find(Filters.eq("type", type.name()))) {
            all.add(Core.getGson().fromJson(Core.getGson().toJson(document), ServerInfo.class));
        }
        return all;
    }

    public List<ServerInfo> getAll() {
        List<ServerInfo> all = new ArrayList<>();
        for (Document document : collection.find()) {
            all.add(Core.getGson().fromJson(Core.getGson().toJson(document), ServerInfo.class));
        }
        return all;
    }
}
