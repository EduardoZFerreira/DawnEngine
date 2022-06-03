package com.boss.levels;

import com.boss.graphics.Spritesheet;
import com.boss.items.Item;
import com.boss.world.World;

import java.util.ArrayList;
import java.util.List;

public class Level {

    public String mapPath;
    public String tilesSpriteSheetPath;

    public String areaName;

    public World world;
    public Spritesheet tilesSpriteSheet;
    public List<Item> items = new ArrayList<>();

    public Level(String mapPath, String tilesSpriteSheetPath, String areaName) {
        this.mapPath = mapPath;
        this.tilesSpriteSheetPath = tilesSpriteSheetPath;
        this.areaName = areaName;
    }

    public void load() {
        tilesSpriteSheet = new Spritesheet(tilesSpriteSheetPath);
        world = new World(mapPath);
    }
}
