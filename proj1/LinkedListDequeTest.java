import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results. */
    @Test
    public void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        // Java will try to run the below code.
        // If there is a failure, it will jump to the finally block before erroring.
        // If all is successful, the finally block will also run afterwards.
        try {
            assertTrue(lld1.isEmpty());

            lld1.addFirst("front");
            assertEquals(1, lld1.size());
            assertFalse(lld1.isEmpty());

            lld1.addLast("middle");
            assertEquals(2, lld1.size());

            lld1.addLast("back");
            assertEquals(3, lld1.size());

        } finally {
            // The deque will be printed at the end of this test
            // or after the first point of failure.
            System.out.println("Printing out deque: ");
            lld1.printDeque();
            int index = 3;
            System.out.printf("Print item at index %d: ", index);
            System.out.println(lld1.get(index));
        }
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        System.out.println("Running add/remove test.");
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        try {
            assertTrue(lld1.isEmpty());

            lld1.addFirst(10);
            lld1.addFirst(4);
            lld1.addFirst(3);
            lld1.addFirst(1);
            lld1.addFirst(7);
            lld1.addFirst(8);
            assertFalse(lld1.isEmpty());
            System.out.println("Printing out deque: ");
            lld1.printDeque();

            lld1.removeFirst();
            lld1.removeLast();
//            assertTrue(lld1.isEmpty());
        } finally {
            System.out.println("Printing out deque: ");
            lld1.printDeque();
        }
    }
}
