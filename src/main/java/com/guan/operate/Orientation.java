package com.guan.operate;

import com.guan.common.CarMessage;

/**
 * The direction of the car
 * @author TianGang.Guan
 */
public enum Orientation {
    EAST, SOUTH, WEST, NORTH;

    private static Orientation[] values = values();

    public Orientation getRotatedOrientation(RotationType rotationType, int times) {
        if (times < 0) {
            throw new IllegalArgumentException(CarMessage.MESSAGE_TIMES_VALUE_NEGATIVE);
        }
        switch(rotationType){
            case CLOCKWISE:
                return values[(this.ordinal() + times) % values.length];
            case ANTICLOCKWISE:
                // Ensure index is not negative.
                return values[(((this.ordinal() - times) % values.length) + values.length) % values.length];
            default:
                return null;
        }
    }
}
