package com.boss.enums.tiles;

public enum TileColorMap {
    WALL_TILE_COLOR(0xFFFFFFFF),
    PLAYER_SPAWN(0xFF00137F),
    AMMO_ITEM(0xFFFFD800),
    WEAPON_ITEM(0xFFFFC85B),
    HEALING_ITEM(0xFFFF006E);

    public final Integer value;

    private TileColorMap(Integer value) {
        this.value = value;
    }
}
