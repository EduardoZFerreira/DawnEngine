package com.boss.enums.items;

import com.boss.graphics.ConsumableSprites;

import java.awt.image.BufferedImage;

public enum ConsumableType {
    SMALL_MEDKIT(ConsumableSprites.SMALL_MEDKIT_SPRITE);

    public final BufferedImage sprite;

    private ConsumableType(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
