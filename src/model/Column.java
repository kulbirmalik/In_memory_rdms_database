package model;

import model.enums.DataType;

public class Column {

    private String name;
    private Object value;
    private DataType dataType;

    public Column(String name, DataType dataType){
        this.name = name;
        this.dataType = dataType;
    }

    public Column(String name, Object value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return this.name;
    }

    public Object getValue(){
        return this.value;
    }

    public DataType getDataType(){
        return this.dataType;
    }

    @Override
    public String toString(){
        return "(" + this.name + ", " + this.value + ")";
    }
}
