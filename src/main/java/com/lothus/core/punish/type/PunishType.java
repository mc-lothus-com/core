package com.lothus.core.punish.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PunishType {

    BAN("Ban"),
    TEMP_BAN("Ban Temporário"),
    MUTE("Mute"),
    TEMP_MUTE("Mute Temporário");

    String display;
}
