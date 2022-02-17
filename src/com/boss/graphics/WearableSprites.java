package com.boss.graphics;

import com.boss.world.World;

import java.awt.image.BufferedImage;

public final class WearableSprites {
    private static final Spritesheet WEARABLE_SPRITESHEET = new Spritesheet("/spritesheets/Items/items.png");

    public static final BufferedImage CHEST_PLATE_SPRITE = WEARABLE_SPRITESHEET.getSprite(3 * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
}
