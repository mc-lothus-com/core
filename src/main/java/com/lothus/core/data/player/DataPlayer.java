package com.lothus.core.data.player;

import com.lothus.core.Core;
import com.lothus.core.player.LothPlayer;
import com.lothus.core.storage.redis.channels.RedisChannel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.UUID;

public class DataPlayer {

    private MongoCollection<Document> collection = Core.getMongo().getDatabase("core").getCollection("players");

    public void create(LothPlayer lothPlayer) {
        Document found = collection.find(Filters.eq("uniqueId", lothPlayer.getUniqueId().toString())).first();
        if (found == null) {
            found = Document.parse(Core.getGson().toJson(lothPlayer));
            collection.insertOne(found);
        }
        Core.getRedis().set("player:" + lothPlayer.getUniqueId().toString(), Core.getGson().toJson(lothPlayer));
        Core.getRedis().message(RedisChannel.PLAYER_ACCOUNT_UPDATE.name(), Core.getGson().toJson(lothPlayer));
    }

    public void update(LothPlayer lothPlayer) {
        collection.updateOne(Filters.eq("uniqueId", lothPlayer.getUniqueId().toString()),
                new Document("$set", Document.parse(Core.getGson().toJson(lothPlayer))));
        Core.getRedis().set("player:" + lothPlayer.getUniqueId().toString(), Core.getGson().toJson(lothPlayer));
        Core.getRedis().message(RedisChannel.PLAYER_ACCOUNT_UPDATE.name(), Core.getGson().toJson(lothPlayer));
    }

    public LothPlayer get(UUID uniqueId) {
        Document found = collection.find(Filters.eq("uniqueId", uniqueId.toString())).first();
        if (found != null) {
            return Core.getGson().fromJson(Core.getGson().toJson(found), LothPlayer.class);
        }
        return null;
    }

    public LothPlayer get(String name) {
        Document found = collection.find(Filters.eq("name", name)).first();
        if (found != null) {
            return Core.getGson().fromJson(Core.getGson().toJson(found), LothPlayer.class);
        }
        return null;
    }
}
