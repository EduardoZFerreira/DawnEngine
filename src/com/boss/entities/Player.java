package com.boss.entities;

import com.boss.enums.entities.Direction;
import com.boss.utils.Utils;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    private Direction direction;

    private Double speed = 1.5;


    public Double health = 100.00;
    public Double armor = 0.00;
    public Integer ammo = 0;
    public Integer combo = 0;
    public Integer score = 0;

    public Player(Integer x, Integer y, Integer width, Integer height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    public void tick() {
        // move();
    }

    public void move() {
        if (direction == Direction.RIGHT) {
            setX(getX() + Utils.toInteger(speed));
        } else if (direction == Direction.LEFT) {
            setX(getX() - Utils.toInteger(speed));
        }

        if (direction == Direction.BOTTOM) {
            setY(getY() + Utils.toInteger(speed));
        } else if (direction == Direction.TOP) {
            setY(getY() - Utils.toInteger(speed));
        }
    }

    public void setSpawnPoint(Integer x, Integer y) {
        setX(x);
        setY(y);
    }
}
