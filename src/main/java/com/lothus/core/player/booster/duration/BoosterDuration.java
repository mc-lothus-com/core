package com.lothus.core.player.booster.duration;

import com.lothus.core.player.booster.duration.type.BoosterDurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BoosterDuration {

    private BoosterDurationType type;
    private int duration;

    private long expires;

}
