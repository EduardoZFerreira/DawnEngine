package com.boss.enums.engine;

import java.util.Arrays;
import java.util.List;

public enum KeyCode {
    VK_W(0x57),
    VK_A(0x41),
    VK_S(0x53),
    VK_D(0x44),
    VK_UP(0x26),
    VK_LEFT(0x25),
    VK_RIGHT(0x27),
    VK_DOWN(0x28);

    public final int value;

    private KeyCode(int value) {
        this.value = value;
    }

    public static List<Integer> listRightMovementKeys() {
        return Arrays.asList(
                VK_D.value,
                VK_RIGHT.value
        );
    }

    public static List<Integer> listLeftMovementKeys() {
        return Arrays.asList(
                VK_A.value,
                VK_LEFT.value
        );
    }

    public static List<Integer> listUpMovementKeys() {
        return Arrays.asList(
                VK_W.value,
                VK_UP.value
        );
    }

    public static List<Integer> listDownMovementKeys() {
        return Arrays.asList(
                VK_S.value,
                VK_DOWN.value
        );
    }
}
