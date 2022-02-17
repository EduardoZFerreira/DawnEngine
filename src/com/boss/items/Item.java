package com.boss.items;

import com.boss.engine.Camera;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {
    private final Double weight;

    private Integer x;
    private Integer y;
    private Integer amount = 0;

    public BufferedImage PICK_UP_SPRITE;

    public Item(Integer x, Integer y, BufferedImage pickUpSprite, Double weight) {
        setX(x);
        setY(y);
        setPickUpSprite(pickUpSprite);
        this.weight = weight;
    }

    public void render(Graphics g) {
        g.drawImage(PICK_UP_SPRITE, x - Camera.x, y - Camera.y, null);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void pickUp() {
    }

    private void setPickUpSprite(BufferedImage pickUpSprite) {
        PICK_UP_SPRITE = pickUpSprite;
    }
}
