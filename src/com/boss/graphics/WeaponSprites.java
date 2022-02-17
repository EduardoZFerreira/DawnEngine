package com.boss.graphics;

import com.boss.world.World;

import java.awt.image.BufferedImage;

public final class WeaponSprites {

    private static final Spritesheet WEAPON_SPRITESHEET = new Spritesheet("/spritesheets/Items/items.png");

    public static final BufferedImage PISTOL_SPRITE = WEAPON_SPRITESHEET.getSprite(1 * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
}
