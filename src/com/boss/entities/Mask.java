package com.boss.entities;

import java.awt.*;

public class Mask {

    protected Integer x;
    protected Integer y;
    protected Integer width;
    protected Integer height;

    public Mask(Integer x, Integer y, Integer width, Integer height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public Boolean isCollidingWithEntity(Entity e1, Entity e2) {
        Rectangle e1Mask = new Rectangle(e1.getX() + x, e1.getY() + y, width, height);
        Rectangle e2Mask = new Rectangle(e2.getX() + x, e2.getY() + y, width, height);
        return e1Mask.intersects(e2Mask);
    }

    public Boolean isCollidingWithItem(Entity entity, Item item) {
        Rectangle entityMask = new Rectangle(entity.getX() + x, entity.getY() + y, width, height);
        Rectangle itemMask = new Rectangle(item.getX() + x, item.getY() + y, width, height);
        return entityMask.intersects(itemMask);
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
