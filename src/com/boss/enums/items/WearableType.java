package com.boss.enums.items;

import com.boss.graphics.WearableSprites;

import java.awt.image.BufferedImage;

public enum WearableType {
    CHEST_PLATE(WearableSprites.CHEST_PLATE_SPRITE);

    public final BufferedImage sprite;

    private WearableType(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
