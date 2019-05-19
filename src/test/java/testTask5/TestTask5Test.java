package testTask5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.*;

public class TestTask5Test {

    @Test
    public void nullLists() {
        List<ObjectA> referenceData = null;
        List<ObjectA> verifiableData = null;

        assertNull(catchThrowable(() -> TestTask5.compareLists(referenceData, verifiableData)));
    }

    /**
     * а) Для id 2 не совпало следующее: Поле field => ожидаемое значение field2, текущее otherField
     * б) Для id 3 не совпало следующее: Поле fieldValue => ожидаемое значение value3, текущее otherValue
     * в) Для id 4 не совпало следующее: Поле field => ожидаемое значение field4, текущее otherField. Для id 4 не
     * совпало следующее: Поле fieldValue => ожидаемое значение value4, текущее otherValue.
     */
    @Test
    public void exampleFromTask() {
        List<ObjectA> referenceData = new ArrayList<>();
        referenceData.add(new ObjectA(1, "field1", "value1"));
        referenceData.add(new ObjectA(2, "field2", "value2"));
        referenceData.add(new ObjectA(3, "field3", "value3"));
        referenceData.add(new ObjectA(4, "field4", "value4"));
        List<ObjectA> verifiableData = new ArrayList<>();
        verifiableData.add(new ObjectA(2, "otherValue", "value2"));
        verifiableData.add(new ObjectA(1, "field1", "value1"));
        verifiableData.add(new ObjectA(3, "field3", "otherValue"));
        verifiableData.add(new ObjectA(4, "otherValue", "otherValue"));

        assertTrue(TestTask5.verifyField(referenceData.get(0), verifiableData.get(1)));
        assertTrue(TestTask5.verifyFieldValue(referenceData.get(0), verifiableData.get(1)));
        assertFalse(TestTask5.verifyField(referenceData.get(1), verifiableData.get(0)));
        assertTrue(TestTask5.verifyFieldValue(referenceData.get(1), verifiableData.get(0)));
        assertTrue(TestTask5.verifyField(referenceData.get(2), verifiableData.get(2)));
        assertFalse(TestTask5.verifyFieldValue(referenceData.get(2), verifiableData.get(2)));
        assertFalse(TestTask5.verifyField(referenceData.get(3), verifiableData.get(3)));
        assertFalse(TestTask5.verifyFieldValue(referenceData.get(3), verifiableData.get(3)));
    }

}