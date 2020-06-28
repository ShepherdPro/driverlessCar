import com.guan.common.CarMessage;
import com.guan.entity.CarPark;
import org.junit.jupiter.api.*;

public class CarParkTest {
    private static final String MESSAGE_SHOULD_BE_THE_SAME = "Should be the same.";
    private static final String MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION = "Test fails with unexpected exception.";

    @BeforeAll
    static void initAll() {
        System.out.println("==Tests CarPark begin==");
    }

    @BeforeEach
    void init() {
    }

    @Test
    public void CarParkTestWithParameter() {
        CarPark actual;
        int expected;
        RuntimeException runtimeException;
        String actualMessage;
        String expectedMessage = CarMessage.MESSAGE_CAR_PARK_PARAMETERS_ERROR;

        // Case 1 -- LengthX = 1, LengthY = 1, NumberX = 1, NumberY = 1
        actual = new CarPark(1, 1, 1, 1);
        expected = 1;
        Assertions.assertEquals(expected, actual.getLengthPerPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getNumberPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getLengthPerPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getNumberPositionY(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 2 -- LengthX = 2, LengthY = 2, NumberX = 2, NumberY = 2
        actual = new CarPark(2, 2, 2, 2);
        expected = 2;
        Assertions.assertEquals(expected, actual.getLengthPerPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getNumberPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getLengthPerPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getNumberPositionY(), MESSAGE_SHOULD_BE_THE_SAME);


        // Case 3 -- LengthX = 0, LengthY = 1, NumberX = 1, NumberY = 1
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarPark(0, 1, 1, 1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 4 -- LengthX = 1, LengthY = 0, NumberX = 1, NumberY = 1
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarPark(1, 0, 1, 1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 5 -- LengthX = 1, LengthY = 1, NumberX = 0, NumberY = 1
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarPark(1, 1, 0, 1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 6 -- LengthX = 1, LengthY = 1, NumberX = 1, NumberY = 0
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarPark(1, 1, 1, 0);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 7 -- LengthX = -1, LengthY = -1, NumberX = -1, NumberY = -1
        runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CarPark(-1, -1, -1, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        actualMessage = runtimeException.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);

    }

    @Test
    public void CarParkTestNonParameter() {
        CarPark actual = new CarPark();
        int expected = 1;
        Assertions.assertEquals(expected, actual.getLengthPerPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getNumberPositionX(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getLengthPerPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
        Assertions.assertEquals(expected, actual.getNumberPositionY(), MESSAGE_SHOULD_BE_THE_SAME);
    }

    @AfterEach
    void destroy() {
    }

    @AfterAll
    static void destroyedAll() {
        System.out.println("--==Tests CarPark Completed==--");
    }
}
