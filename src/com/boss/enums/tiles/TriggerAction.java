package com.boss.enums.tiles;

public enum TriggerAction {
    CHANGE_LEVEL(0xFFFFFFFE);

    private Integer value;

    private TriggerAction(Integer value) {
        this.value = value;
    }

    public static  Boolean contains(Integer value) {
        for (TriggerAction action : TriggerAction.values()) {
            if (action.value.equals(value)) return true;
        }
        return false;
    }

    public static TriggerAction convert(Integer value) {
        for (TriggerAction action : TriggerAction.values()) {
            if (action.value.equals(value)) return action;
        }
        return null;
    }
}
