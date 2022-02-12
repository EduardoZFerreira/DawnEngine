package com.boss.engine;

import com.boss.entities.Entity;
import com.boss.world.World;

public class Camera {

    public static Integer x = 0;
    public static Integer y = 0;

    private static Integer clamp(Integer currentPosition, Integer minPosition, Integer maxPosition) {
        if(currentPosition < minPosition) {
            currentPosition = minPosition;
        }

        if(currentPosition > maxPosition) {
            currentPosition = maxPosition;
        }
        return currentPosition;
    }

    public static void followTarget(Entity target) {
        x = clamp(target.x, 0, World.WIDTH * World.TILE_SIZE - Game.WIDTH);
        y = clamp(target.y, 0, World.HEIGHT * World.TILE_SIZE - Game.HEIGHT);
    }
}
