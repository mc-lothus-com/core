package com.lothus.core.discord.group;

import com.lothus.core.player.group.rank.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Group {

    private UUID id;
    private Rank rank;

}
