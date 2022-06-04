package com.boss.levels;

import com.boss.graphics.Spritesheet;
import com.boss.items.Item;
import com.boss.world.World;

import java.util.ArrayList;
import java.util.List;

public class Level {

    public Integer chapterNumber;
    public Integer levelNumber;

    public String areaName;

    public World world;
    public Spritesheet tilesSpriteSheet;
    public List<Item> items = new ArrayList<>();

    public Level(Integer chapterNumber, Integer levelNumber, String areaName) {
        this.chapterNumber = chapterNumber;
        this.levelNumber = levelNumber;
        this.areaName = areaName;
    }

    public void load() {
        tilesSpriteSheet = new Spritesheet("/spritesheets/Levels/Chapter_" + chapterNumber + "/level_" + levelNumber + ".png");
        world = new World("/maps/Chapter_" + chapterNumber + "/level_" + levelNumber + ".png");
    }
}
