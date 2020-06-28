import com.guan.common.CarMessage;
import com.guan.operate.Orientation;
import com.guan.operate.RotationType;
import org.junit.jupiter.api.*;

public class OrientationTest {
    private static final String MESSAGE_SHOULD_BE_THE_SAME = "Should be the same.";
    private static final String MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION = "Test fails with unexpected exception.";
    private final Orientation orientation = Orientation.EAST;

    @BeforeAll
    static void initAll() {
        System.out.println("Tests Orientation Begin");
    }

    @BeforeEach
    void init() {
    }

    @Test
    public void getRotatedOrientationTest_CLOCKWISE() {
        Orientation actual = null;
        Orientation expected = null;


        // Case 1 -- EAST, CLOCKWISE, -1 times
        RuntimeException runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        String actualMessage = runtimeException.getMessage();
        String expectedMessage = CarMessage.MESSAGE_TIMES_VALUE_NEGATIVE;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 2 -- EAST, CLOCKWISE, 0 times
        actual = this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, 0);
        expected = Orientation.EAST;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 3 -- EAST, CLOCKWISE, 1 times
        actual = this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, 1);
        expected = Orientation.SOUTH;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 4 -- EAST, CLOCKWISE, 2 times
        actual = this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, 2);
        expected = Orientation.WEST;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 5 -- EAST, CLOCKWISE, 3 times
        actual = this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, 3);
        expected = Orientation.NORTH;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 6 -- EAST, CLOCKWISE, 4 times
        actual = this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, 4);
        expected = Orientation.EAST;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 7 -- EAST, CLOCKWISE, 5 times
        actual = this.orientation.getRotatedOrientation(RotationType.CLOCKWISE, 5);
        expected = Orientation.SOUTH;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);
    }

    @Test
    public void getRotatedOrientationTest_ANTICLOCKWISE() {
        Orientation actual = null;
        Orientation expected = null;


        // Case 1 -- EAST, ANTICLOCKWISE, -1 times
        RuntimeException runtimeException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, -1);
                },
                MESSAGE_TEST_FAILS_WITH_UNEXPECTED_EXCEPTION);
        String actualMessage = runtimeException.getMessage();
        String expectedMessage = CarMessage.MESSAGE_TIMES_VALUE_NEGATIVE;
        Assertions.assertEquals(expectedMessage, actualMessage, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 2 -- EAST, ANTICLOCKWISE, 0 times
        actual = this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, 0);
        expected = Orientation.EAST;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 3 -- EAST, ANTICLOCKWISE, 1 times
        actual = this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, 1);
        expected = Orientation.NORTH;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 4 -- EAST, ANTICLOCKWISE, 2 times
        actual = this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, 2);
        expected = Orientation.WEST;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 5 -- EAST, ANTICLOCKWISE, 3 times
        actual = this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, 3);
        expected = Orientation.SOUTH;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 6 -- EAST, ANTICLOCKWISE, 4 times
        actual = this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, 4);
        expected = Orientation.EAST;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);


        // Case 7 -- EAST, ANTICLOCKWISE, 5 times
        actual = this.orientation.getRotatedOrientation(RotationType.ANTICLOCKWISE, 5);
        expected = Orientation.NORTH;
        Assertions.assertEquals(expected, actual, MESSAGE_SHOULD_BE_THE_SAME);
    }

    @AfterEach
    void destroy() {
    }

    @AfterAll
    static void destroyedAll() {
        System.out.println("Tests completed");
    }
}
