import static org.junit.Assert.*;
import org.junit.Test;


public class ArrayDequeTest {

    @Test
    public  void  addAndRemoveTest() {
        ArrayDeque<String> arrayD = new ArrayDeque();
        arrayD.addLast("a");
        arrayD.addLast("b");
        arrayD.addFirst("c");
        arrayD.addLast("d");
        arrayD.addLast("e");
        arrayD.addFirst("f");
        arrayD.addLast("g");
        arrayD.addLast("h");
        arrayD.removeLast();
        arrayD.removeFirst();
        String expected = "c a b d e g";
        System.out.println("\n" + expected);

    }
    @Test
    public  void  getTest() {
        ArrayDeque<String> arrayD = new ArrayDeque();
        arrayD.addLast("a");
        arrayD.addLast("b");
        arrayD.addFirst("c");
        arrayD.addLast("d");
        arrayD.addLast("e");
        arrayD.addFirst("f");
        arrayD.addLast("g");
        arrayD.addLast("h");
        arrayD.removeLast();
        arrayD.removeFirst();
        String expected = "c a b d e g";
        String getchar = arrayD.get(-4);
        assertNull(getchar);

        getchar = arrayD.get(6);
        assertNull(getchar);

        getchar = arrayD.get(5);
        assertEquals("g", getchar);

        getchar = arrayD.get(3);
        assertEquals("d", getchar);
    }
    @Test
    public  void  resizeTest() {
        ArrayDeque<String> arrayD = new ArrayDeque();
        int N = 8;
        for (int i = 0; i < N; i++) {
            arrayD.addFirst("a");
        }
        for (int i = 0; i < N - 1; i++) {
            arrayD.removeFirst();
        }

        N = 64;
        for (int i = 0; i < N; i++) {
            arrayD.addFirst("a");
        }
        for (int i = 0; i < N - 1; i++) {
            arrayD.removeFirst();
        }
    }
}
