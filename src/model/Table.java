package model;

import model.enums.DataType;

import java.util.*;

import static model.enums.DataType.INTEGER;
import static model.enums.DataType.STRING;

public class Table {

    private String tableName;
    private String primaryKey;
    private List<Row> rows;
    private List<Column> columns;
    private String createdBy;
    private Date createdAt;
    private Date updatedAt;

    public Table(String tableName, String primaryKey, List<Column> columns){
        this.tableName = tableName;
        this.primaryKey = primaryKey;
        this.columns = columns;
        this.rows = new ArrayList<>();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void insertData(Map<String, Object> values){
        for(Row row : rows){
            List<Column> columns = row.getColumns();
            if(checkIfSameValueExist(columns, values)){
                System.out.println("Values cannot be inserted.");
            }
        }
        Row rowToBeInserted = new Row();
        for(Column column : columns){
            if(!isValidDataType(column.getDataType(), values.get(column.getName()))){
                System.out.println("Data type do not match with column data type.");
            }
        }
        rowToBeInserted.addColumnValues(values);
        rows.add(rowToBeInserted);
    }

    public List<Row> getRows() {
        return this.rows;
    }

    private boolean isValidDataType(DataType dataType, Object value) {
        return switch (dataType) {
            case STRING -> value instanceof String;
            case INTEGER -> value instanceof Integer;
            case FLOAT -> value instanceof Float;
            case BOOLEAN -> value instanceof Boolean;
        };
    }

    private boolean checkIfSameValueExist(List<Column> columns, Map<String, Object> valueMap) {
        for(Column column : columns){
            if(Objects.equals(column.getName(), primaryKey) && valueMap.get(column.getName()).equals(column.getValue())){
                System.out.println("Entry with given primary key already exists.");
                return true;
            }
        }
        return false;
    }

    public String getTableName(){
        return this.tableName;
    }

}
