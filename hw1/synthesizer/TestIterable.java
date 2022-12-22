package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestIterable {

    @Test
    public void IterableTest() {

    }
    public static void main(String[] args) {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<Double>(10);
        for (int i = 0; i < 10; i++) {
            arb.enqueue((double) i);
        }
        for (double item : arb) {
            System.out.println(item);
        }
    }

}
