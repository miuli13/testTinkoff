package testTask3;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestTask3Test {


    @Test
    public void nullString(){
        assertNull(TestTask3.deletePairedLetters(null));
    }

    /**
     * Пример: aaabccddd => abd
     */
    @Test
    public void firstExampleFromTask(){
        assertEquals("abd", TestTask3.deletePairedLetters("aaabccddd"));
    }

    /**
     * baab => пусто
     */
    @Test
    public void secondExampleFromTask(){
        assertEquals("", TestTask3.deletePairedLetters("baab"));
    }

}