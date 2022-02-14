package com.boss.entities;

import com.boss.engine.Camera;
import com.boss.engine.Game;
import com.boss.enums.entities.ItemType;
import com.boss.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    private Integer x;
    private Integer y;

    private ItemType type;

    public BufferedImage PICK_UP_SPRITE;

    public Item(Integer x, Integer y, ItemType type) {
        setX(x);
        setY(y);
        setType(type);
        setPickUpSprite();
    }

    public void render(Graphics g) {
        g.drawImage(PICK_UP_SPRITE, (int)getX() - Camera.x, (int)getY() - Camera.y, null);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public ItemType getType() {
        return type;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public void setPickUpSprite() {
        Game game = Game.getInstance();
        PICK_UP_SPRITE = game.itemsSpritesheet.getSprite(type.columnPosition * World.TILE_SIZE, type.linePosition * World.TILE_SIZE, World.TILE_SIZE, World.TILE_SIZE);
    }
}
