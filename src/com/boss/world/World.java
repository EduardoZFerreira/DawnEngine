package com.boss.world;

import com.boss.engine.Camera;
import com.boss.engine.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class World {

    public static Tile[] tiles;
    public static Integer WIDTH, HEIGHT;
    public static final Integer TILE_SIZE = 16;

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

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        int startX = Camera.x / TILE_SIZE;
        int startY = Camera.y / TILE_SIZE;

        int finalX = startX + (Game.WIDTH / TILE_SIZE);
        int finalY = startY + (Game.HEIGHT / TILE_SIZE);

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
