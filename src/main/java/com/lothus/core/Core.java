package com.lothus.core;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.lothus.core.api.hologram.HologramManager;
import com.lothus.core.controller.game.GameController;
import com.lothus.core.controller.party.PartyController;
import com.lothus.core.controller.player.PlayerController;
import com.lothus.core.controller.punish.PunishController;
import com.lothus.core.controller.punish.ReportController;
import com.lothus.core.controller.rejoin.RejoinController;
import com.lothus.core.controller.server.ServerController;
import com.lothus.core.controller.vincule.VinculeController;
import com.lothus.core.data.app.DataAccountAPP;
import com.lothus.core.data.party.DataParty;
import com.lothus.core.data.player.DataPlayer;
import com.lothus.core.data.server.DataServer;
import com.lothus.core.data.report.DataReport;
import com.lothus.core.servers.ServerInfo;
import com.lothus.core.storage.mongo.MongoStorage;
import com.lothus.core.storage.redis.Redis;
import com.lothus.core.utils.fetcher.UUIDFetcher;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

public class Core {

    @Getter @Setter
    private static Redis redis;

    @Getter @Setter
    private static Logger logger;

    @Getter @Setter
    private static DataParty dataParty;

    @Getter @Setter
    private static ServerInfo serverInfo;

    @Getter @Setter
    private static DataPlayer dataPlayer;

    @Getter @Setter
    private static DataServer dataServer;

    @Getter @Setter
    private static DataReport dataReport;

    @Getter @Setter
    private static DataAccountAPP dataAccountAPP;

    @Getter @Setter
    private static UUIDFetcher uniqueIdFetcher;

    @Getter @Setter
    private static HologramManager hologramManager;

    @Getter @Setter
    private static JsonParser parser = new JsonParser();


    @Getter
    private static Gson gson = new Gson();

    @Getter
    private static MongoStorage mongo = new MongoStorage();

    @Getter
    private static GameController gameController = new GameController();

    @Getter
    private static PartyController partyController = new PartyController();

    @Getter
    private static RejoinController rejoinController = new RejoinController();

    @Getter
    private static ReportController reportController = new ReportController();

    @Getter
    private static PlayerController playerController = new PlayerController();

    @Getter
    private static ServerController serverController = new ServerController();

    @Getter
    private static PunishController punishController = new PunishController();

    @Getter
    private static VinculeController vinculeController = new VinculeController();


}