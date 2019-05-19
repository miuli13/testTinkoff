package testTask5;

import java.util.Objects;

class ObjectA {
    private final int id;
    private final String field;
    private final String fieldValue;

    ObjectA(final int id, final String field, final String fieldValue) {
        this.id = id;
        this.field = field;
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectA objectA = (ObjectA) o;
        return id == objectA.id &&
                Objects.equals(field, objectA.field) &&
                Objects.equals(fieldValue, objectA.fieldValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, field, fieldValue);
    }

    int getId(){
        return id;
    }
    String getField(){
        return field;
    }
    String getFieldValue(){
        return fieldValue;
    }



}
