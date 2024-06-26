import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Your test should test at least the following three situations:
     * That the function returns a reversed list.
     * That the function is destructive, i.e. when it is done running,
     * the list pointed to by A has been tampered with.
     * You can use assertNotEquals. This is sort of a silly test.
     * That the method handles a null input properly.
     */
    @Test(timeout = 1000)
    public  void  reverseTest() {

        IntList input1 = IntList.of(0, 1, 2, 3);
        IntList output1 = IntList.reverse(input1);
        IntList expected1 = IntList.of(3, 2, 1, 0);
        assertEquals(expected1, output1);


        IntList input2 = IntList.of(4, 5, 6, 7);
        IntList.reverse(input2);
        IntList expected2 = IntList.of(4, 5, 6, 7);
        assertNotEquals(expected2, input2);


        IntList input3 = null;
        IntList output3 = IntList.reverse(input3);
        IntList expected3 = null;
        assertEquals(expected3, output3);






    }
    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.of(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.of(1, 2, 3), L);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.of(1, 2, 3), A);
    }

    /** If you're running this from the command line, you'll need
      * to add a main method. See ArithmeticTest.java for an
      * example. */

}
