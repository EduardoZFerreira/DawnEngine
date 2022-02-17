package com.boss.enums.items;

import com.boss.graphics.AmmoSprites;

import java.awt.image.BufferedImage;

public enum AmmoType {
    PISTOL_AMMO(AmmoSprites.PISTOL_AMMO_SPRITE);

    public final BufferedImage sprite;

    private AmmoType(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
