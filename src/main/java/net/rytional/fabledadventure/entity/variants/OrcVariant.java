package net.rytional.fabledadventure.entity.variants;

import java.util.Arrays;
import java.util.Comparator;

public enum OrcVariant {
    DEFAULT(0),
    GRAY(1),
    DARK(2);

    private static final OrcVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(OrcVariant::getId)).toArray(OrcVariant[]::new);
    private final int id;

    OrcVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static OrcVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
