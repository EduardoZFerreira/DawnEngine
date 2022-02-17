package com.boss.graphics;

import com.boss.world.World;

import java.awt.image.BufferedImage;

public final class ConsumableSprites {
    private static final Spritesheet CONSUMABLE_SPRITESHEET = new Spritesheet("/spritesheets/Items/items.png");

    public static final BufferedImage SMALL_MEDKIT_SPRITE = CONSUMABLE_SPRITESHEET.getSprite(2  * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
}
