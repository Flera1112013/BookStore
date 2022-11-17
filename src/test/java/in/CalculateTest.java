package in;

import org.junit.Test;
import test.Calculate;

import static org.junit.Assert.assertEquals;

public class CalculateTest {
    @Test
    public void increaseBy2Test(){
        Calculate calculate = new Calculate();
        assertEquals(4.0,calculate.increaseBy2(2.0), 0.0000001);
    }
    @Test
    public void connectStringTest(){
        Calculate calculate = new Calculate();
        assertEquals("Hello, World", calculate.connectString("Hello,"));
    }
}
