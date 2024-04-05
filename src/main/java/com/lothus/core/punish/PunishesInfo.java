package com.lothus.core.punish;


import com.lothus.core.punish.reason.PunishReason;
import com.lothus.core.punish.type.PunishType;
import com.lothus.core.utils.key.RandomKey;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Getter @Setter
public class PunishesInfo {

    private String id;

    private String author;
    private UUID uniqueId;
    private PunishType type;
    private PunishReason reason;

    private String evidence;

    private boolean unBan;
    private boolean expired;

    private long deleteStsts;
    private long expires;

    public PunishesInfo(String author, UUID uniqueId, PunishReason reason, String evidence) {
        id = RandomKey.generate();

        this.author = author;
        this.uniqueId = uniqueId;
        this.reason = reason;
        this.evidence = evidence;

        type = reason.getType();

        if (reason.equals(PunishReason.DISCRIMINATION) || reason.equals(PunishReason.OFFENSE_TO_SERVER) || reason.equals(PunishReason.OFFENSE_TO_STAFF)) {
            unBan = false;
        } else {
            unBan = true;
        }

        deleteStsts = (reason == PunishReason.HACK ? System.currentTimeMillis() + TimeUnit.DAYS.toMillis(3) : -1L);
        expired = false;
        expires = (reason.getTimeInDays() == 99999 ? -1L : System.currentTimeMillis() + TimeUnit.DAYS.toMillis(reason.getTimeInDays()));
    }
}
