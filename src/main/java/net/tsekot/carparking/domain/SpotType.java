package net.tsekot.carparking.domain;

public enum SpotType {
    SMALL(0),
    MIDDLE(1),
    BIG(2);

    private int type;

    SpotType(int type) {
        this.type = type;
    }

    public static SpotType fromString(String spotType) {
        int value = Integer.parseInt(spotType);

        for (SpotType type : SpotType.values()) {
            if (type.type == value) return type;
        }
        throw new IllegalArgumentException("No such Spot type: " + spotType);
    }
}
