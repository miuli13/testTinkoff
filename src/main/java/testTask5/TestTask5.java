package testTask5;

import java.util.List;

import org.slf4j.Logger;

class TestTask5 {
    private static String errorString = "Для id {} не совпало следующее: Поле {} => ожидаемое  значение {}, текущее {}. ";
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TestTask5.class);

    /**
     * Даны два листа List<ObjectA> (исходные/справочные данные и проверяемые данные). ObjectA содержит поля: int id
     * (уникально), String field, String fieldValue.  Ваша задача проверить, что у обоих листов поля одинаковы (попарно,
     * т.е. field сравнивается с field, fieldValue сравнивается с fieldValue) и в случае несовпадения вывести в консоль
     * сообщение об ошибке сравнения каждого поля для каждого id.
     */

    static void compareLists(List<ObjectA> referenceData, List<ObjectA> verifiableData) {
        if (referenceData != null && verifiableData != null) {

            for (ObjectA reference : referenceData) { //была не уверена, можно ли использовать что-то, кроме List
                for (ObjectA verifiable : verifiableData) {

                    if (reference.getId()==verifiable.getId() && !reference.equals(verifiable)) {

                        if (!verifyField(reference, verifiable)) log.error (errorString,
                                    reference.getId(), "field", reference.getField(), verifiable.getField());

                        if (!verifyFieldValue(reference, verifiable)) log.error(errorString,
                                    reference.getId(), "fieldValue", reference.getFieldValue(), verifiable.getFieldValue());
                    }
                }
            }
        }
    }

    static boolean verifyField(ObjectA reference, ObjectA verifiable){
        return reference.getField().equals(verifiable.getField());

    }

    static boolean verifyFieldValue(ObjectA reference, ObjectA verifiable){
        return reference.getFieldValue().equals(verifiable.getFieldValue());
    }
}
