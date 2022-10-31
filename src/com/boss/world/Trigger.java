package com.boss.world;

import com.boss.enums.tiles.TriggerAction;

import java.awt.image.BufferedImage;

public class Trigger extends Tile {

    TriggerAction action;

    public Trigger(Integer x, Integer y, BufferedImage sprite, TriggerAction action) {
        super(x, y, sprite);
        this.action = action;
    }
}
