package com.boss.world;

import com.boss.engine.Camera;
import com.boss.engine.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static BufferedImage FLOOR_TILE;
    public static BufferedImage WALL_TILE;

    private final BufferedImage sprite;
    private final Integer x;
    private final Integer y;

    public Tile(Integer x, Integer y, BufferedImage sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        loadSprites();
    }

    public void render(Graphics g) {
        g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
    }

    private void loadSprites() {
        Game game = Game.getInstance();
        FLOOR_TILE = game.level.tilesSpriteSheet.getSprite(0, 0, World.TILE_SIZE, World.TILE_SIZE);
        WALL_TILE = game.level.tilesSpriteSheet.getSprite(World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
    }
}
