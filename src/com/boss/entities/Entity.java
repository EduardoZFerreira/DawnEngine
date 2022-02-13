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

    protected BufferedImage sprite;
    protected Mask mask;

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

    public Boolean isColliding(Entity e1, Entity e2) {
        Rectangle e1Mask = new Rectangle(e1.getX() + mask.x, e1.getY() + mask.y, mask.width, mask.height);
        Rectangle e2Mask = new Rectangle(e2.getX() + mask.x, e2.getY() + mask.y, mask.width, mask.height);
        return e1Mask.intersects(e2Mask);
    }
}
