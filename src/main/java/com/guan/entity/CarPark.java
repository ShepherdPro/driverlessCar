package com.guan.entity;

import com.guan.Car;
import com.guan.common.CarMessage;

import java.io.Serializable;

/**
 * Car park
 */
public class CarPark implements Serializable {

    /**
     * 每位置长度 x
     */
    private int lengthPerPositionX;

    /**
     * 每位置长度 Y
     */
    private int lengthPerPositionY;

    /**
     * the total of X
     */
    private int numberPositionX;

    /**
     * the total of Y
     */
    private int numberPositionY;

    public CarPark(int lengthPerPositionX, int lengthPerPositionY, int numberPositionX, int numberPositionY) {
        if ((lengthPerPositionX < 1) || (lengthPerPositionY < 1) || (numberPositionX < 1) || (numberPositionY < 1)) {
            throw new IllegalArgumentException(CarMessage.MESSAGE_CAR_PARK_PARAMETERS_ERROR);
        }
        this.lengthPerPositionX = lengthPerPositionX;
        this.lengthPerPositionY = lengthPerPositionY;
        this.numberPositionX = numberPositionX;
        this.numberPositionY = numberPositionY;
        printCarParkInfoAndMap();
    }

    public CarPark() {
        this(1, 1, 1, 1);
    }

    public int getLengthPerPositionX() {
        return lengthPerPositionX;
    }

    public void setLengthPerPositionX(int lengthPerPositionX) {
        this.lengthPerPositionX = lengthPerPositionX;
    }

    public int getLengthPerPositionY() {
        return lengthPerPositionY;
    }

    public void setLengthPerPositionY(int lengthPerPositionY) {
        this.lengthPerPositionY = lengthPerPositionY;
    }

    public int getNumberPositionX() {
        return numberPositionX;
    }

    public void setNumberPositionX(int numberPositionX) {
        this.numberPositionX = numberPositionX;
    }

    public int getNumberPositionY() {
        return numberPositionY;
    }

    public void setNumberPositionY(int numberPositionY) {
        this.numberPositionY = numberPositionY;
    }

    public void printCarParkInfoAndMap() {
        printCarParkInfoAndMap(null);
    }

    public void printCarParkInfoAndMap(Car car) {
        System.out.println("Car Park numberPositionX = " + this.numberPositionX);
        System.out.println("Car Park numberPositionY = " + this.numberPositionY);
        System.out.println("Car Park lengthPerPositionX = " + this.lengthPerPositionX);
        System.out.println("Car Park lengthPerPositionY = " + this.lengthPerPositionY);

        int rowNumber = this.numberPositionY * (this.lengthPerPositionY + 1) + 2;
        int columnNumber = this.numberPositionX * (this.lengthPerPositionX + 1) + 2;
        for (int i = 0; i < rowNumber; i++) {
            if ((i % (lengthPerPositionY + 1)) == 0) { // The line like "+---+---+---+---+"

                // The first and the second columns
                if (i == 0) {   // The first and the second columns of first row line
                    System.out.print(" (Y)+");
                } else {        // The first and the second columns of non-first row line
                    System.out.print("    +");
                }

                // The rest columns
                for (int j = 2; j < columnNumber; j++) {
                    if ((j - 1) % (lengthPerPositionX + 1) == 0) {
                        System.out.print("+");
                    } else {
                        System.out.print("----");
                    }
                }
            } else {    // The line like "|   |   |   |   |"

                // The first and the second columns
                if (i == rowNumber - 1) {   // The last row line
                    System.out.print("     ");
                } else {
                    int Y = (rowNumber - 2) - i - (((rowNumber - 2) - (i)) / (lengthPerPositionY + 1));
                    System.out.printf(" %02d |", Y);
                }

                // The rest columns
                for (int j = 2; j < columnNumber; j++) {
                    if ((j - 1) % (lengthPerPositionX + 1) == 0) {  // The boundary
                        if (i == rowNumber - 1) {   // The last row line
                            if (j == columnNumber - 1) {    // The last column of the last row line
                                System.out.print("(X)");
                            } else {
                                System.out.print(" ");
                            }
                        } else {
                            System.out.print("|");
                        }
                    } else {
                        if (i == rowNumber - 1) {   // The last row line
                            int X = (j - 1) - ((j - 1) / (lengthPerPositionX + 1));
                            System.out.printf(" " + "%02d" + " ", X);
                        } else {
                            // Print car's position
                            if ((car != null)
                                    && (((j - 1) > ((car.getPositionX() - 1) * (lengthPerPositionX + 1))) && ((j - 1) < (car.getPositionX() * (lengthPerPositionX + 1))))
                                    && ((i > ((numberPositionY - car.getPositionY()) * (lengthPerPositionY + 1))) && (i < ((numberPositionY - car.getPositionY() + 1) * (lengthPerPositionY + 1))))) {
                                String carString = null;
                                switch (car.getOrientation()) {
                                    case EAST:
                                        carString = " E E";
                                        break;
                                    case SOUTH:
                                        carString = " S S";
                                        break;
                                    case WEST:
                                        carString = " W W";
                                        break;
                                    case NORTH:
                                        carString = " N N";
                                        break;
                                    default:
                                        break;
                                }
                                System.out.print(carString);
                            } else {
                                System.out.print("    ");
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
