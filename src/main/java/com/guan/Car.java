package com.guan;

import com.guan.entity.CarPark;
import com.guan.operate.Direction;
import com.guan.operate.Orientation;
import com.guan.operate.RotationType;

public interface Car {

    void move(Direction direction, int steps);

    void turn(RotationType rotationType, int times);

    int getPositionX();

    void setPositionX(int positionX);

    int getPositionY();

    void setPositionY(int positionY);

    Orientation getOrientation();

    void setOrientation(Orientation orientation);

    CarPark getCarPark();

    void setCarPark(CarPark carPark);

}
