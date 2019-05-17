package testTask7;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTask7Test {

    @Test
    public void fizzBuzzPositiveTest () {
        TestTask7 testTask7 = new TestTask7();
        assertEquals("4", testTask7.fizzBuzzNumber(4));
        assertEquals("Fizz", testTask7.fizzBuzzNumber(-12));
        assertEquals("Buzz", testTask7.fizzBuzzNumber(35));
        assertEquals("FizzBuzz", testTask7.fizzBuzzNumber(-45));
    }

    @Test
    public void fizzBuzzNegativeTest () {
        TestTask7 testTask7 = new TestTask7();
        assertNotEquals("5", testTask7.fizzBuzzNumber(5));
        assertNotEquals("Fizz", testTask7.fizzBuzzNumber(45));
        assertNotEquals("Buzz", testTask7.fizzBuzzNumber(60));
    }


}