package com.lothus.core.data.app;

import com.lothus.core.Core;
import com.lothus.core.app.AccountAPP;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.UUID;

public class DataAccountAPP {

    private MongoCollection<Document> collection = Core.getMongo().getDatabase("app").getCollection("profiles");

    public void create(AccountAPP accountAPP) {
        Document found = collection.find(Filters.eq("nickname", accountAPP.getNickname())).first();
        if (found == null) {
            found = Document.parse(Core.getGson().toJson(accountAPP));
            collection.insertOne(found);
        }
    }

    public void update(AccountAPP accountAPP) {
        collection.updateOne(Filters.eq("nickname", accountAPP.getNickname()),
                new Document("$set", Document.parse(Core.getGson().toJson(accountAPP))));
    }

    public AccountAPP get(String name) {
        Document found = collection.find(Filters.eq("nickname", name)).first();
        if (found != null) {
            return Core.getGson().fromJson(Core.getGson().toJson(found), AccountAPP.class);
        }
        return null;
    }
}
