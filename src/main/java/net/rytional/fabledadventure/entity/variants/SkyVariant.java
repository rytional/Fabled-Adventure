package net.rytional.fabledadventure.entity.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum SkyVariant {
    DEFAULT(0),
    DARK(1),
    WHITE(2);

    private static final SkyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SkyVariant::getId)).toArray(SkyVariant[]::new);
    private final int id;

    SkyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SkyVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
