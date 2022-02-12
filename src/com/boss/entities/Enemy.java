package com.boss.entities;

import java.awt.image.BufferedImage;

public class Enemy extends Entity {

    private Double speed = 1.00;
    private Integer health = 100;
    public final Integer DAMAGE = 1;

    public Enemy(Integer x, Integer y, Integer width, Integer height, BufferedImage sprite) {
        super(x, y, width, height, sprite);
    }
}
