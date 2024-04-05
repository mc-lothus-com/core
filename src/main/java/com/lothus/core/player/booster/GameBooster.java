package com.lothus.core.player.booster;

import com.lothus.core.games.room.RoomType;
import com.lothus.core.games.type.GameType;
import com.lothus.core.player.booster.duration.BoosterDuration;
import com.lothus.core.player.booster.status.BoosterStatus;
import com.lothus.core.player.booster.type.BoosterType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class GameBooster {

    private GameType gameType;
    private BoosterType type;
    private BoosterStatus status;

    private double multiplier;
    private BoosterDuration duration;
}
