package com.boss.entities;

import com.boss.enums.entities.SpriteDirection;
import com.boss.enums.entities.State;
import com.boss.utils.Utils;

import java.awt.image.BufferedImage;

public class Player extends Entity {
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveUp = false;
    private boolean moveDown = false;

    private SpriteDirection direction;
    private State state = State.IDLE;

    private Double speed = 5.00;

    public Double health = 100.00;
    public Double armor = 0.00;
    public Integer ammo = 0;
    public Integer combo = 0;
    public Integer score = 0;

    public Player(Integer x, Integer y, Integer width, Integer height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    public void tick() {
        move();

    }

    public void move() {
        if (moveRight) {
            setX(Utils.toInteger(getX() + speed));
        } else if (moveLeft) {
            setX(Utils.toInteger(getX() - speed));
        }

        if (moveDown) {
            setY(Utils.toInteger(getY() + speed));
        } else if (moveUp) {
            setY(Utils.toInteger(getY() - speed));
        }
    }

    public void setSpriteDirection(SpriteDirection direction) {
        this.direction = direction;
        setState(State.MOVING);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setSpawnPoint(Integer x, Integer y) {
        setX(x);
        setY(y);
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
        if (moveLeft) this.moveRight = false;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
        if (moveRight) this.moveLeft = false;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
        if (moveUp) this.moveDown = false;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
        if (moveDown) this.moveUp = false;
    }
}
