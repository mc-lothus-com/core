package com.lothus.core.player.skin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Skin {

    private String name;
    private UUID uuid;

    private String value;
    private String signature;
}
