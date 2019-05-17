package testTask6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestTask6Test {

    @Test
    public void emptyStandardKeysList() {
        List<String> standardKeys = new ArrayList<String>();
        List<String> dataBaseKeys = new ArrayList<String>();
        dataBaseKeys.add("A");
        dataBaseKeys.add("B");
        TestTask6 testTask6 = new TestTask6();

        assertEquals(dataBaseKeys, testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertNull(testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

    @Test
    public void emptyDataBaseKeysList() {
        List<String> standardKeys = new ArrayList<String>();
        standardKeys.add("A");
        standardKeys.add("B");
        List<String> dataBaseKeys = new ArrayList<String>();
        TestTask6 testTask6 = new TestTask6();

        assertNull(testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertEquals(standardKeys, testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

    @Test
    public void nullStandardKeysList() {
        List<String> standardKeys = null;
        List<String> dataBaseKeys = new ArrayList<String>();
        dataBaseKeys.add("A");
        dataBaseKeys.add("B");
        TestTask6 testTask6 = new TestTask6();

        assertEquals(dataBaseKeys, testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertNull(testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

    @Test
    public void nullBothLists() {
        List<String> standardKeys = null;
        List<String> dataBaseKeys = null;
        TestTask6 testTask6 = new TestTask6();

        assertNull(testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertNull(testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

    @Test
    public void nullDataBaseKeysList() {
        List<String> standardKeys = new ArrayList<String>();
        standardKeys.add("A");
        standardKeys.add("B");
        List<String> dataBaseKeys = null;
        TestTask6 testTask6 = new TestTask6();

        assertNull(testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertEquals(standardKeys, testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

    /**
     * эталонные ключи «A, B, C, D»; ключи в БД «A, B, C, D, E» => а) вывести «E»; б) ничего не выводим. 
     */
    @Test
    public void firstExampleFromTask () {
        List<String> standardKeys = new ArrayList<String>();
        standardKeys.add("A");
        standardKeys.add("B");
        standardKeys.add("C");
        standardKeys.add("D");
        List<String> dataBaseKeys = new ArrayList<String>();
        dataBaseKeys.add("A");
        dataBaseKeys.add("B");
        dataBaseKeys.add("C");
        dataBaseKeys.add("D");
        dataBaseKeys.add("E");
        TestTask6 testTask6 = new TestTask6();

        List<String> firstResult = new ArrayList<String>();
        firstResult.add("E");
        List<String> secondResult = new ArrayList<String>();
        assertEquals(firstResult, testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertEquals(secondResult, testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

    /**
     * Эталонные ключи «A, B, C, D»; ключи в БД «A, B, C, E» => а) выводим «E»; б) выводим «D»
     */
    @Test
    public void secondExampleFromTask() {
        List<String> standardKeys = new ArrayList<String>();
        standardKeys.add("A");
        standardKeys.add("B");
        standardKeys.add("C");
        standardKeys.add("D");
        List<String> dataBaseKeys = new ArrayList<String>();
        dataBaseKeys.add("A");
        dataBaseKeys.add("B");
        dataBaseKeys.add("C");
        dataBaseKeys.add("E");
        TestTask6 testTask6 = new TestTask6();

        List<String> firstResult = new ArrayList<String>();
        firstResult.add("E");
        List<String> secondResult = new ArrayList<String>();
        secondResult.add("D");
        assertEquals(firstResult, testTask6.checkKeysNotStored(dataBaseKeys, standardKeys));
        assertEquals(secondResult, testTask6.checkKeysNotStored(standardKeys, dataBaseKeys));
    }

}