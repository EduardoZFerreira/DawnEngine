package com.boss.world;

import com.boss.engine.Camera;
import com.boss.engine.Game;
import com.boss.enums.tiles.TileColorMap;
import com.boss.enums.tiles.TriggerAction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class World {

    public static Tile[] tiles; // TODO: Remove static

    public List<Trigger> triggers = new ArrayList<>();

    public static Integer WIDTH, HEIGHT;
    public static final Integer TILE_SIZE = 128;

    public World(String path) {
        try {
            BufferedImage map = ImageIO.read(getClass().getResource(path));
            int[] pixels = new int[map.getWidth() * map.getHeight()];
            tiles = new Tile[pixels.length];
            map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
            WIDTH =  map.getWidth();
            HEIGHT =  map.getHeight();
            for (int xx = 0; xx < map.getWidth(); xx++) {
                for(int yy = 0; yy < map.getHeight(); yy++) {
                    Integer color = pixels[xx + (yy * map.getWidth())];
                    tiles[xx + (yy * WIDTH)] = new FloorTile(xx * TILE_SIZE, yy * TILE_SIZE, Tile.FLOOR_TILE);
                    if (color.equals(TileColorMap.WALL_TILE_COLOR.value)) {
                        tiles[xx + (yy * WIDTH)] = new WallTile(xx * TILE_SIZE, yy * TILE_SIZE, Tile.WALL_TILE);
                    } else if (color.equals(TileColorMap.PLAYER_SPAWN.value)) {
                        Game.getInstance().player.setSpawnPoint(xx * TILE_SIZE, yy * TILE_SIZE);
                    } else if (TriggerAction.contains(color)) {
                        Trigger trigger = new Trigger(xx * TILE_SIZE, yy * TILE_SIZE, Tile.FLOOR_TILE, TriggerAction.convert(color));
                        triggers.add(trigger);
                        tiles[xx + (yy * WIDTH)] = trigger;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean nextTileIsWallTile(Integer nextXPosition, Integer nextYPosition) {
        Integer topLeftCornerX = (int)(nextXPosition + (TILE_SIZE * 0.2)) / TILE_SIZE;
        Integer topLeftCornerY = nextYPosition / TILE_SIZE;

        Integer topLeftCornerXOffset = (int)(nextXPosition + TILE_SIZE - (TILE_SIZE * 0.2)) / TILE_SIZE;
        Integer topLeftCornerYOffset = (nextYPosition + TILE_SIZE) / TILE_SIZE;

        return !((tiles[topLeftCornerX + (topLeftCornerY * WIDTH)] instanceof WallTile)
                || (tiles[topLeftCornerXOffset + (topLeftCornerY * WIDTH)] instanceof WallTile)
                || (tiles[topLeftCornerX + (topLeftCornerYOffset * WIDTH)] instanceof WallTile)
                || (tiles[topLeftCornerXOffset + (topLeftCornerYOffset * WIDTH)] instanceof WallTile));
    }

    public void render(Graphics g) {
        int startX = Camera.x / TILE_SIZE;
        int startY = Camera.y / TILE_SIZE;

        int finalX = startX + (Game.WIDTH / TILE_SIZE) + TILE_SIZE;
        int finalY = startY + (Game.HEIGHT / TILE_SIZE) + TILE_SIZE;

        for(int xx = startX; xx <= finalX; xx++) {
            for(int yy = startY; yy <= finalY; yy++) {
                if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT) {
                    continue;
                }
                Tile tile = tiles[xx + (yy * WIDTH)];
                tile.render(g);
            }
        }
    }
}
