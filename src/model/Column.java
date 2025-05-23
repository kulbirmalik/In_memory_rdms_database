package model;

import model.enums.DataType;

public class Column {
    private String name;
    private Object value;
    private DataType dataType;

    public Column(String name, Object value){
        this.name = name;
        this.value = value;
    }

    public Column(String name, DataType dataType){
        this.name = name;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", dataType=" + dataType +
                '}';
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
