package com.boss.entities;

import com.boss.engine.Camera;
import com.boss.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    protected int width, height;
    public Integer x;
    public Integer y;

    protected BufferedImage sprite;
    protected Mask mask = new Mask(0, 0, World.TILE_SIZE, World.TILE_SIZE);

    public Entity(Integer x, Integer y, Integer width, Integer height, BufferedImage sprite) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setSprite(sprite);
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
}
