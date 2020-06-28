import com.guan.common.CarMessage;
import com.guan.entity.CarPark;
import com.guan.impl.CarImpl;
import com.guan.operate.Direction;
import com.guan.operate.Orientation;
import com.guan.operate.RotationType;
import org.junit.jupiter.api.*;

public class CarTest {

    private static final String MESSAGE_SHOULD_BE_THE_SAME = "Should be the same.";

    private static final String MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION = "Test fails with unexpected exception.";

    @BeforeAll
    static void initAll() {
        System.out.println("==Tests Car Begin==");
    }

    @BeforeEach
    void init() {
    }

    @Test
    public void CarImplTest_WithParameter() {
        CarImpl actual;
        int expected;
        Orientation expectedOrientation;
        RuntimeException runtimeException;
        String actualMessage;
        String expectedMessage = CarMessage.MESSAGE_CAR_IMPL_PARAMETERS_ERROR;

        // Case 1 -- X = 1, Y = 1, EAST
        actual = new CarImpl(1, 1, Orientation.EAST);
        expected = 1;
        expectedOrientation = Orientation.EAST;
        Assertions.assertEquals(expected, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 2 -- X = 2, Y = 2, SOUTH
        actual = new CarImpl(2, 2, Orientation.SOUTH);
        expected = 2;
        expectedOrientation = Orientation.SOUTH;
        Assertions.assertEquals(expected, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 3 -- X = 0, Y = 1, SOUTH
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarImpl(0, 1, Orientation.SOUTH);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 4 -- X = 1, Y = 0, SOUTH
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarImpl(1, 0, Orientation.SOUTH);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 5 -- X = -1, Y = -1, SOUTH
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarImpl(-1, -1, Orientation.SOUTH);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);
    }

    @Test
    public void CarImplTest_WithoutParameter() {
        CarImpl actual = new CarImpl();
        int expected = 1;
        Orientation expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(expected, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);
    }

    @Test
    public void moveTest() {
        CarPark carPark = new CarPark(1, 1, 5, 5);
        CarImpl actual = new CarImpl();
        actual.setCarPark(carPark);

        RuntimeException runtimeException;
        String actualMessage;
        String expectedMessage;

        int expectedPositionX;
        int expectedPositionY;
        Orientation expectedOrientation;


        // Case 1 -- move 1 step forward facing north.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.NORTH);
        actual.move(Direction.FORWARD, 1);

        expectedPositionX = 3;
        expectedPositionY = 4;
        expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 2 -- move 2 step forward facing north.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.NORTH);
        actual.move(Direction.FORWARD, 2);

        expectedPositionX = 3;
        expectedPositionY = 5;
        expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 3 -- move 3 step forward facing north.
        runtimeException = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    actual.setPositionX(3);
                    actual.setPositionY(3);
                    actual.setOrientation(Orientation.NORTH);
                    actual.move(Direction.FORWARD, 3);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);

        expectedPositionX = 3;
        expectedPositionY = 6;
        expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);

        actualMessage = runtimeException.getMessage();
        expectedMessage = CarMessage.MESSAGE_CAR_OUT_OF_BOUNDARIES;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 4 -- move 0 step forward facing north.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.NORTH);
        actual.move(Direction.FORWARD, 0);

        expectedPositionX = 3;
        expectedPositionY = 3;
        expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 5 -- move -1 step forward facing north.
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    actual.setPositionX(3);
                    actual.setPositionY(3);
                    actual.setOrientation(Orientation.NORTH);
                    actual.move(Direction.FORWARD, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);

        actualMessage = runtimeException.getMessage();
        expectedMessage = CarMessage.MESSAGE_STEPS_VALUE_NEGATIVE;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 6 -- move 1 step backward facing north.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.NORTH);
        actual.move(Direction.BACKWARD, 1);

        expectedPositionX = 3;
        expectedPositionY = 2;
        expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 7 -- move 2 step backward facing north.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.NORTH);
        actual.move(Direction.BACKWARD, 2);

        expectedPositionX = 3;
        expectedPositionY = 1;
        expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 8 -- move 3 step backward facing north.
        runtimeException = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    actual.setPositionX(3);
                    actual.setPositionY(3);
                    actual.setOrientation(Orientation.NORTH);
                    actual.move(Direction.BACKWARD, 3);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);

        expectedPositionX = 3;
        expectedPositionY = 0;
        expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);

        actualMessage = runtimeException.getMessage();
        expectedMessage = CarMessage.MESSAGE_CAR_OUT_OF_BOUNDARIES;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 9 -- move 0 step backward facing north.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.NORTH);
        actual.move(Direction.BACKWARD, 0);

        expectedPositionX = 3;
        expectedPositionY = 3;
        expectedOrientation = Orientation.NORTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 10 -- move -1 step backward facing north.
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    actual.setPositionX(3);
                    actual.setPositionY(3);
                    actual.setOrientation(Orientation.NORTH);
                    actual.move(Direction.BACKWARD, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);

        actualMessage = runtimeException.getMessage();
        expectedMessage = CarMessage.MESSAGE_STEPS_VALUE_NEGATIVE;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 11 -- move 1 step forward facing east.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.EAST);
        actual.move(Direction.FORWARD, 1);

        expectedPositionX = 4;
        expectedPositionY = 3;
        expectedOrientation = Orientation.EAST;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 12 -- move 1 step backward facing east.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.EAST);
        actual.move(Direction.BACKWARD, 1);

        expectedPositionX = 2;
        expectedPositionY = 3;
        expectedOrientation = Orientation.EAST;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 13 -- move 1 step forward facing south.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.SOUTH);
        actual.move(Direction.FORWARD, 1);

        expectedPositionX = 3;
        expectedPositionY = 2;
        expectedOrientation = Orientation.SOUTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 14 -- move 1 step backward facing south.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.SOUTH);
        actual.move(Direction.BACKWARD, 1);

        expectedPositionX = 3;
        expectedPositionY = 4;
        expectedOrientation = Orientation.SOUTH;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 15 -- move 1 step forward facing west.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.WEST);
        actual.move(Direction.FORWARD, 1);

        expectedPositionX = 2;
        expectedPositionY = 3;
        expectedOrientation = Orientation.WEST;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 16 -- move 1 step backward facing west.
        actual.setPositionX(3);
        actual.setPositionY(3);
        actual.setOrientation(Orientation.WEST);
        actual.move(Direction.BACKWARD, 1);

        expectedPositionX = 4;
        expectedPositionY = 3;
        expectedOrientation = Orientation.WEST;

        Assertions.assertEquals(expectedPositionX, actual.getPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedPositionY, actual.getPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);
    }

    @Test
    public void turnTest() {
        CarImpl actual = new CarImpl();
        Orientation expectedOrientation;
        RuntimeException runtimeException;
        String actualMessage;
        String expectedMessage;


        // Case 1 -- NORTH, CLOCKWISE, -1 times
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    actual.setOrientation(Orientation.NORTH);
                    actual.turn(RotationType.CLOCKWISE, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        expectedMessage = CarMessage.MESSAGE_TIMES_VALUE_NEGATIVE;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 2 -- NORTH, CLOCKWISE, 0 times
        actual.setOrientation(Orientation.NORTH);
        actual.turn(RotationType.CLOCKWISE, 0);
        expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 3 -- NORTH, CLOCKWISE, 1 times
        actual.setOrientation(Orientation.NORTH);
        actual.turn(RotationType.CLOCKWISE, 1);
        expectedOrientation = Orientation.EAST;
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 4 -- NORTH, ANTICLOCKWISE, -1 times
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    actual.setOrientation(Orientation.NORTH);
                    actual.turn(RotationType.ANTICLOCKWISE, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        expectedMessage = CarMessage.MESSAGE_TIMES_VALUE_NEGATIVE;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 5 -- NORTH, ANTICLOCKWISE, 0 times
        actual.setOrientation(Orientation.NORTH);
        actual.turn(RotationType.ANTICLOCKWISE, 0);
        expectedOrientation = Orientation.NORTH;
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 6 -- NORTH, ANTICLOCKWISE, 1 times
        actual.setOrientation(Orientation.NORTH);
        actual.turn(RotationType.ANTICLOCKWISE, 1);
        expectedOrientation = Orientation.WEST;
        Assertions.assertEquals(expectedOrientation, actual.getOrientation(), MESSAGE_SHOULD_BE_THE_SAME);

    }

    @AfterEach
    void destroy() {
    }

    @AfterAll
    static void destroyedAll() {
        System.out.println("--==Tests  Car Completed==--");
    }
}
