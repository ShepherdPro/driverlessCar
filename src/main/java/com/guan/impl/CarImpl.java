package com.guan.impl;

import com.guan.Car;
import com.guan.common.CarMessage;
import com.guan.entity.CarPark;
import com.guan.operate.Direction;
import com.guan.operate.Orientation;
import com.guan.operate.RotationType;

import java.io.Serializable;

/**
 * Is's a car and action
 */
public class CarImpl implements Car , Serializable {

    private int positionX;

    private int positionY;

    private Orientation orientation;

    private CarPark carPark;

    public CarImpl(int positionX, int positionY, Orientation orientation) {
        if ((positionX < 1) || (positionY < 1)) {
            throw new IllegalArgumentException(CarMessage.MESSAGE_CAR_IMPL_PARAMETERS_ERROR);
        }
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public CarImpl() {
        this(1, 1, Orientation.NORTH);
    }

    @Override
    public void move(Direction direction, int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException(CarMessage.MESSAGE_STEPS_VALUE_NEGATIVE);
        }
        if (direction == Direction.FORWARD) {
            switch (this.orientation) {
                case EAST:
                    this.positionX += steps;
                    break;
                case SOUTH:
                    this.positionY -= steps;
                    break;
                case WEST:
                    this.positionX -= steps;
                    break;
                case NORTH:
                    this.positionY += steps;
                    break;
                default:
                    break;
            }
        }
        if (direction == Direction.BACKWARD) {
            switch (this.orientation) {
                case EAST:
                    this.positionX -= steps;
                    break;
                case SOUTH:
                    this.positionY += steps;
                    break;
                case WEST:
                    this.positionX += steps;
                    break;
                case NORTH:
                    this.positionY -= steps;
                    break;
                default:
                    break;
            }
        }

        printCarPosition();

        if ((this.positionX < 1) ||
                (this.positionY < 1) ||
                (this.positionX > this.carPark.getNumberPositionX()) ||
                (this.positionY > this.carPark.getNumberPositionY())) {
            throw new RuntimeException(CarMessage.MESSAGE_CAR_OUT_OF_BOUNDARIES);
        }
    }

    @Override
    public void turn(RotationType rotationType, int times) {
        if (times < 0) {
            throw new IllegalArgumentException(CarMessage.MESSAGE_TIMES_VALUE_NEGATIVE);
        }
        this.orientation = this.orientation.getRotatedOrientation(rotationType, times);
        this.printCarPosition();
    }

    public void printCarPosition() {
        System.out.println("Car's PositionX = " + this.getPositionX());
        System.out.println("Car's PositionY = " + this.getPositionY());
        System.out.println("Car's Orientation = " + this.getOrientation().name());
    }

    @Override
    public int getPositionX() {
        return this.positionX;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public Orientation getOrientation() {
        return this.orientation;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public CarPark getCarPark() {
        return this.carPark;
    }

    @Override
    public void setCarPark(CarPark carPark) {
        System.out.println("===init car park====");
        printCarPosition();
        if ((this.getPositionX() > carPark.getNumberPositionX()) || (this.getPositionY() > carPark.getNumberPositionY())) {
            throw new RuntimeException(CarMessage.MESSAGE_CAR_OUT_OF_BOUNDARIES);
        }
        this.carPark = carPark;
    }
}
