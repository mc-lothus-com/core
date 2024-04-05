package com.lothus.core.punish.reason;

import com.lothus.core.punish.type.PunishType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PunishReason {

    HACK("Uso de trapaças", PunishType.BAN, 99999),
    FALSIFICATION_OF_EVIDENCE("Falsificação de provas", PunishType.BAN, 99999),
    BLACKMAIL_OR_BRIBERY("Chantagem ou suborno", PunishType.BAN, 99999),
    OFFENSE_TO_SERVER("Ofensa ao servidor", PunishType.BAN, 99999),
    OFFENSE_TO_STAFF("Ofensa a staff", PunishType.BAN, 99999),
    DISCRIMINATION("Discriminação", PunishType.BAN, 99999),
    INAPPROPRIATE_NICK("Nick inapropriado", PunishType.BAN, 99999),
    INAPPROPRIATE_SKIN("Skin inapropriada", PunishType.BAN, 99999),
    ENCOURAGE_SUICIDE("Incentivar o sucídio", PunishType.BAN, 99999),
    CHARGE_BACK("Chargeback", PunishType.BAN, 99999),
    THEFT("Roubo", PunishType.BAN, 99999),
    BUGS_ABUSE("Abuso de bugs", PunishType.TEMP_BAN, 4),
    SERIOUS_DISCLOSURE("Divulgação (Grave)", PunishType.TEMP_BAN, 7),
    INADEQUATE_CONSTRUCTIONS("Construções inadequadas", PunishType.TEMP_BAN, 7),
    INCORRECT_USE_OF_COMMANDS("Uso incorreto de comandos", PunishType.TEMP_BAN, 1),
    FALSE_ACCUSATIONS("Falsas acusações", PunishType.TEMP_MUTE, 2),
    THREATS("Ameaças", PunishType.TEMP_MUTE, 7),
    BUSINESS("Comércio", PunishType.TEMP_MUTE, 1),
    PROVOKE_DISORDER("Provocar desordem (flood, spam, etc...)", PunishType.TEMP_MUTE, 1),
    SIMPLE_DISCLOSURE("Divulgação (Simples)", PunishType.TEMP_MUTE, 1);

    String display;
    PunishType type;
    Integer timeInDays;

    public static PunishReason getTagByName(String name) {
        for (PunishReason tag : PunishReason.values()) {
            if (tag.name().equalsIgnoreCase(name.toUpperCase())) {
                return tag;
            }
        }
        return null;
    }


    public static boolean exists(String name) {
        for (PunishReason tag : PunishReason.values()) {
            if (tag.name().equalsIgnoreCase(name.toUpperCase()))
                return true;
        }
        return false;
    }
}
