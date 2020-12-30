import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        ArrayDeque<String> arr1 = new ArrayDeque<>();
        ArrayDeque<String> arr2 = new ArrayDeque<>(8);

        System.out.println("Printing out empty array deque: ");
        arr1.printDeque();
        System.out.println("Printing out array deque: ");
        arr2.printDeque();

        // Java will try to run the below code.
        // If there is a failure, it will jump to the finally block before erroring.
        // If all is successful, the finally block will also run afterwards.
        try {
            assertTrue(arr1.isEmpty());
            arr1.addFirst("front");
            assertEquals("front", arr1.get(0));
            assertFalse(arr1.isEmpty());

            arr1.addLast("middle");
            assertEquals("middle", arr1.get(7));

            arr1.addLast("back");
            assertEquals("back", arr1.get(7));

        } finally {
            // The deque will be printed at the end of this test
            // or after the first point of failure.
            System.out.println("Printing out array deque: ");
            arr1.printDeque();
            int index = 3;
            System.out.printf("Print item at index %d: ", index);
            System.out.println(arr1.get(index));
        }
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        System.out.println("Running add/remove test.");
        ArrayDeque<Integer> arr1 = new ArrayDeque<>();

        try {
            assertTrue(arr1.isEmpty());

            arr1.addFirst(10);
            arr1.addFirst(4);
            arr1.addFirst(3);
            arr1.addFirst(1);
            arr1.addFirst(7);
            arr1.addFirst(8);
            assertFalse(arr1.isEmpty());
            System.out.println("Printing out deque: ");
            arr1.printDeque();

            arr1.removeFirst();
            arr1.removeLast();
            System.out.println("Printing out deque after removing first and last indexes: ");
            arr1.printDeque();

            for (int i=0;i < 10000;i++) {
                arr1.addFirst(1);
                arr1.addLast(2);
            }
            for (int i=0;i < 10000;i++) {
                arr1.removeFirst();
                arr1.removeLast();
            }
            System.out.println("Printing out deque after removing first index: ");
            arr1.printDeque();

        } finally {
            System.out.println("Printing out deque: ");
            arr1.printDeque();
        }
    }
}
