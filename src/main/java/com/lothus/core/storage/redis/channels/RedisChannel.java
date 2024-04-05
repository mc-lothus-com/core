package com.lothus.core.storage.redis.channels;

import java.util.Arrays;
import java.util.List;

public enum RedisChannel {

    SERVER_START,
    SERVER_UPDATE,
    SERVER_STOP,

    GAME_START,
    GAME_UPDATE,
    GAME_STOP,

    PLAYER_ACCOUNT_UPDATE,
    PLAYER_CONNECT_SERVER,

    DISCORD_VINCULE_ACCOUNT,
    DISCORD_UNVINCULE_ACCOUNT,

    DISCORD_UPDATE_GROUP,
    DISCORD_ALTER_GROUP,

    APP_UPDATE_ACCOUNT,
    BUY_IN_APP,

    REJOIN,

    CLAN_UPDATE,
    CLAN_DELETE,
    CLAN_INVITE_PLAYER,
    CLAN_REMOVE_PLAYER,

    MAINTENANCE;

}
