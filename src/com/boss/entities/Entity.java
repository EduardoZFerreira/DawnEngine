package com.boss.entities;

import com.boss.engine.Camera;
import com.boss.engine.Game;
import com.boss.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    protected int width, height;
    public Integer x;
    public Integer y;


    public static BufferedImage LIFEPACK_EN;
    public static BufferedImage WEAPON_EN;
    public static BufferedImage BULLET_EN;
    public static BufferedImage ENEMY_EN;
    public static BufferedImage WEAPON_LEFT;
    public static BufferedImage WEAPON_UP;
    public static BufferedImage WEAPON_DOWN;

    protected BufferedImage sprite;
    protected Mask mask;

    public Entity(Integer x, Integer y, Integer width, Integer height, BufferedImage sprite) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setSprite(sprite);
        loadSprites();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public void render(Graphics g)
    {
        g.drawImage(sprite, (int)getX() - Camera.x, (int)getY() - Camera.y, null);
    }

    public void tick() {

    }

    public Boolean isColliding(Entity e1, Entity e2) {
        Rectangle e1Mask = new Rectangle(e1.getX() + mask.x, e1.getY() + mask.y, mask.width, mask.height);
        Rectangle e2Mask = new Rectangle(e2.getX() + mask.x, e2.getY() + mask.y, mask.width, mask.height);
        return e1Mask.intersects(e2Mask);
    }


    private void loadSprites() {
        Game game = Game.getInstance();
        LIFEPACK_EN = game.spritesheet.getSprite(6 * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
        WEAPON_EN = game.spritesheet.getSprite(7 * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
        BULLET_EN = game.spritesheet.getSprite(6 * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);
        ENEMY_EN = game.spritesheet.getSprite(8 * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE);
        WEAPON_LEFT = game.spritesheet.getSprite(7 * World.TILE_SIZE, 1 * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);
        WEAPON_UP = game.spritesheet.getSprite(7 * World.TILE_SIZE, 2 * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);
        WEAPON_DOWN = game.spritesheet.getSprite(7 * World.TILE_SIZE, 3 * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);
    }
}
