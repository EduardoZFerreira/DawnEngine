package com.boss.enums.items;

import com.boss.graphics.WeaponSprites;

import java.awt.image.BufferedImage;

public enum WeaponType {
    PISTOL(WeaponSprites.PISTOL_SPRITE);

    public final BufferedImage sprite;

    private WeaponType(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
