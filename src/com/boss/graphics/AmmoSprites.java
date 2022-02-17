package com.boss.graphics;

import com.boss.world.World;

import java.awt.image.BufferedImage;

public final class AmmoSprites {
    private static final Spritesheet AMMO_SPRITESHEET = new Spritesheet("/spritesheets/Items/items.png");

    public static final BufferedImage PISTOL_AMMO_SPRITE = AMMO_SPRITESHEET.getSprite(0, 0, World.TILE_SIZE, World.TILE_SIZE);
}
