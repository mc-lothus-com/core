package com.lothus.core.data.report;

import com.lothus.core.Core;
import com.lothus.core.punish.report.ReportInfo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.*;

public class DataReport {

    private MongoCollection<Document> collection = Core.getMongo().getDatabase("core").getCollection("reports");

    public void create(ReportInfo reportInfo) {
        Document found = Document.parse(Core.getGson().toJson(reportInfo));
        collection.insertOne(found);
    }

    public void delete(ReportInfo reportInfo) {
        Document found = collection.find(Filters.eq("reported", reportInfo.getReported().toString())).first();
        if (found != null) {
            collection.deleteOne(Filters.eq("reported", reportInfo.getReported().toString()));
        }
    }

    public ReportInfo get(UUID uniqueId) {
        Document found = collection.find(Filters.eq("reported", uniqueId.toString())).first();
        if (found != null) {
            return Core.getGson().fromJson(Core.getGson().toJson(found), ReportInfo.class);
        }
        return null;
    }

    public List<ReportInfo> getReports() {
        List<ReportInfo> servers = new ArrayList<>();
        for (Document found : collection.find()) {
            servers.add(Core.getGson().fromJson(Core.getGson().toJson(found), ReportInfo.class));
        }
        return servers;
    }
}
