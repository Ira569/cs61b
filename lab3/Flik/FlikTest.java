import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void isSameNumberTest(){
        boolean output = Flik.isSameNumber(1,2);
        assertTrue(!output);
        output =Flik.isSameNumber(3,3);
        assertTrue("3==3" ,output);
        output =Flik.isSameNumber(128,128);
        assertTrue("128==128",output);


    }
}
