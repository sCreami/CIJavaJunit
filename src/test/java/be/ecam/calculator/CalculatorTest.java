package be.ecam.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calc;
    
    public CalculatorTest() {
        this.calc = new Calculator();
    }
    
    @Test
    public void testAdd() {        
        assertAll("addition",
            () -> assertEquals(2, calc.add(1, 1), 1e-6),
            () -> assertEquals(3, calc.add(1, 2), 1e-6)
        );
    }

    @Test
    public void testSub() {
        assertAll("subtraction",
            () -> assertEquals(0, calc.sub(1, 1), 1e-6),
            () -> assertEquals(1, calc.sub(2, 1), 1e-6)
        );
    }

    @Test
    public void testMul() {
        assertAll("multiplication",
            () -> assertEquals( 1, calc.mul(1,  1), 1e-6),
            () -> assertEquals(-2, calc.mul(1, -2), 1e-6)
        );
    }

    @Test
    public void testDiv() { 
        assertAll("division",
            () -> assertEquals(  1, calc.div(1, 1), 1e-6),
            () -> assertEquals(0.5, calc.div(1, 2), 1e-6),
            () -> assertThrows(
                    IllegalArgumentException.class,
                    () -> calc.div(1, 0)
            )
        );
    }
    
    @Test
    public void testMain() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        //redirect the System-output (normaly the console) to a variable
        System.setErr(new PrintStream(errContent));
        
        Calculator.main(new String[1]);
        
        assertEquals("Should not have been called that way.\n",
                errContent.toString());
    }
    
}
