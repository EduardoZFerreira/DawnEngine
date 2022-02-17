package com.boss.entities;

import com.boss.engine.Camera;
import com.boss.engine.Game;
import com.boss.enums.entities.SpriteDirection;
import com.boss.enums.entities.State;
import com.boss.items.Item;
import com.boss.utils.Utils;
import com.boss.world.World;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean moveUp = false;
    private boolean moveDown = false;

    private SpriteDirection direction;
    private State state = State.IDLE;

    private Double speed = 5.00;

    private Inventory inventory = new Inventory();

    public Double health = 100.00;
    public Double armor = 0.00;
    public Integer ammo = 0;
    public Integer combo = 0;
    public Integer score = 0;

    public Player(Integer x, Integer y, Integer width, Integer height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }

    public void render(Graphics g) {
        g.drawImage(sprite, (int)getX() - Camera.x, (int)getY() - Camera.y, null);

//        Ammo ammo = inventory.ammo.stream()
//                .filter(ammunition -> ammunition.getType().equals(AmmoType.PISTOL))
//                .findAny()
//                .orElse(null);
//
//        if (ammo != null) {
//            g.setColor(Color.WHITE);
//
//            g.setFont(new Font("arial", Font.BOLD, 16));
//            g.drawString("Munição de pistola: " + ammo.getAmmount(), x - Camera.x, y - 10 - Camera.y);
//        }
    }

    public void tick() {
        move();
        checkItemCollisions();
    }

    public void move() {
        if (moveRight && World.nextTileIsWallTile((int)(x + speed), y)) {
            setX(Utils.toInteger(getX() + speed));
        } else if (moveLeft && World.nextTileIsWallTile((int)(x - speed), y)) {
            setX(Utils.toInteger(getX() - speed));
        }

        if (moveDown && World.nextTileIsWallTile(x, (int)(y + speed))) {
            setY(Utils.toInteger(getY() + speed));
        } else if (moveUp && World.nextTileIsWallTile(x, (int)(y - speed))) {
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

    private void checkItemCollisions() {
        Double currentCarryWeight = inventory.calculateCurrentCarryWeight();
        Game game = Game.getInstance();
        for (Integer i = 0; i < game.items.size(); i++) {
            Item item = game.items.get(i);
            if (mask.isCollidingWithItem(this, item) && (currentCarryWeight + item.getType().size) <= inventory.getCarryCapacity()) {
                pickUp(item);
                game.items.remove(item);
            }
        }
    }

    private void pickUp(Item item) {
//        switch (item.getType()) {
//            case PISTOL_AMMO:
//                inventory.addAmmo(AmmoType.PISTOL);
//                break;
//            default:
//                break;
//        }
    }

}
