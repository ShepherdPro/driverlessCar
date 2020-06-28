import com.guan.Car;
import com.guan.entity.CarPark;
import com.guan.impl.CarImpl;
import com.guan.operate.Direction;
import com.guan.operate.Orientation;
import com.guan.operate.RotationType;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEnter {

    private static final Logger logger = LoggerFactory.getLogger(MainEnter.class);

    public static void main(String[] args) {
        // Set up a simple configuration that logs on the console.
        BasicConfigurator.configure();

        logger.info("-------------------------------------");
        logger.info("--- == This is a driverless car == --");
        logger.info("-------------------------------------");

        // Acceptance Criteria Cases
        CarPark carPark = new CarPark(1, 1, 4, 4);

        // Case 1 -- Given the Car is in position X = 1 and Y = 1 and facing North,
        // when the Car turns clockwise,
        // then the Car is still in the same position but is now facing East
        Car car1 = new CarImpl(1, 1, Orientation.NORTH);
        car1.setCarPark(carPark);
        carPark.printCarParkInfoAndMap(car1);
        car1.turn(RotationType.CLOCKWISE, 1);
        carPark.printCarParkInfoAndMap(car1);

        // Case 2 -- Given the Car is in position X = 1 and Y = 1 and facing North,
        // when the Car moves forward,
        // then the Car is still facing North but is now in position X = 1 and Y = 2
        Car car2 = new CarImpl(1, 1, Orientation.NORTH);
        car2.setCarPark(carPark);
        carPark.printCarParkInfoAndMap(car2);
        car2.move(Direction.FORWARD, 1);
        carPark.printCarParkInfoAndMap(car2);


        // Case 3 -- Given the Car is in position X = 1 and Y = 1 and facing East,
        // when the Car moves forward,
        // then the Car is still facing East but is now in position X = 2 and Y = 1
        Car car3 = new CarImpl(1, 1, Orientation.EAST);
        car3.setCarPark(carPark);
        carPark.printCarParkInfoAndMap(car3);
        car3.move(Direction.FORWARD, 1);
        carPark.printCarParkInfoAndMap(car3);


        // Case 4 -- Given the Car is in position X = 1 and Y = 1 and facing West,
        // when the Car moves forward, then an exception is thrown
        Car car4 = new CarImpl(1, 1, Orientation.WEST);
        car4.setCarPark(carPark);
        carPark.printCarParkInfoAndMap(car4);
        try {
            car4.move(Direction.FORWARD, 1);
            carPark.printCarParkInfoAndMap(car4);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


        // Case 4 -- Given the Car is in position X = 1 and Y = 1 and facing East,
        // when the Car moves forward twice,
        // then the Car is still facing East but is now in position X = 3 and Y = 1
        Car car5 = new CarImpl(1, 1, Orientation.EAST);
        car5.setCarPark(carPark);
        carPark.printCarParkInfoAndMap(car5);
        car5.move(Direction.FORWARD, 2);
        carPark.printCarParkInfoAndMap(car5);
        // Other cases
        CarPark carPark6 = new CarPark(2, 2, 10, 10);
        Car car6 = new CarImpl(1, 1, Orientation.NORTH);
        car6.setCarPark(carPark6);
        carPark6.printCarParkInfoAndMap(car6);
        car6.move(Direction.FORWARD, 2);
        carPark6.printCarParkInfoAndMap(car6);
        car6.turn(RotationType.CLOCKWISE, 1);
        carPark6.printCarParkInfoAndMap(car6);
        car6.move(Direction.FORWARD, 3);
        carPark6.printCarParkInfoAndMap(car6);
        car6.turn(RotationType.ANTICLOCKWISE, 1);
        carPark6.printCarParkInfoAndMap(car6);
        car6.move(Direction.FORWARD, 3);
        carPark6.printCarParkInfoAndMap(car6);
        car6.turn(RotationType.ANTICLOCKWISE, 5);
        carPark6.printCarParkInfoAndMap(car6);
        car6.move(Direction.FORWARD, 2);
        carPark6.printCarParkInfoAndMap(car6);

    }
}
