package com.boss.enums.tiles;

public enum TileColorMap {
    WALL_TILE_COLOR(0xFFFFFFFF),
    FLOOR_TILE_COLOR(0xFF000000),
    PLAYER_SPAWN(0xFF00137F);

    public final Integer value;

    private TileColorMap(Integer value) {
        this.value = value;
    }
}
