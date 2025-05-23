package service.impl;

import model.Column;
import model.Row;
import model.Table;
import model.TableCreateRequest;
import model.enums.DataType;
import service.DbService;
import service.TableService;

import java.util.*;

public class TableServiceImpl implements TableService {

    private final Map<String, List<Table>> databaseToTableMap;

    private final DbService dbService;

    public TableServiceImpl(DbService dbService){
        this.databaseToTableMap = new HashMap<>();
        this.dbService = dbService;
    }

    @Override
    public Table createTableDefinition(TableCreateRequest tableCreateRequest) {
        String databaseName = tableCreateRequest.getDatabaseName();
        if(dbService.checkIfDatabaseExist(databaseName)){
            Table table = new Table();
            table.setTableName(tableCreateRequest.getTableName());
            table.setColumns(tableCreateRequest.getColumns());
            table.setPrimaryKey(tableCreateRequest.getPrimaryKey());
            table.setSecondaryIndexes(tableCreateRequest.getSecondaryIndexes());
            table.setCreatedAt(new Date());
            table.setModifiedAt(new Date());
            databaseToTableMap.computeIfAbsent(databaseName, k -> new ArrayList<>()).add(table);
            return table;
        } else{
            throw new RuntimeException("The database do not exist : " + databaseName);
        }
    }

    @Override
    public Table updateTableDefinition() {
        return null;
    }

    @Override
    public void removeTableDefinition(String tableName) {

    }

    @Override
    public List<Row> addDataToTable(String databaseName, String tableName, Map<String, List<Column>> valuesToBeInserted) {
        if(databaseToTableMap.containsKey(databaseName)){
            List<Table> tableList = databaseToTableMap.get(databaseName);
            if(checkIfTableExist(tableList, tableName)){
                Table table = getTableFromList(tableList, tableName);
                validateValuesToBeAdded(table, valuesToBeInserted);
                List<Row> rowsAdded = insertRecordsInTable(table, valuesToBeInserted);
                return rowsAdded;
            } else{
                throw new RuntimeException("Unable to find the given table : {} " + tableName);
            }
        }else{
            throw new RuntimeException("Unable to find the given database : {} " + databaseName);
        }
    }

    private List<Row> insertRecordsInTable(Table table, Map<String, List<Column>> valuesToBeInserted) {
        List<Row> rowsToBeAdded = new ArrayList<>();
        for(String recordKey : valuesToBeInserted.keySet()){
            List<Column> columns = valuesToBeInserted.get(recordKey);
            Row row = new Row();
            row.setRowId(UUID.randomUUID());
            row.setCreatedAt(new Date());
            row.setModifiedAt(new Date());
            row.setColumns(columns);
            rowsToBeAdded.add(row);
            addPrimaryKeyRow(table, row, columns);
        }
        table.setRows(rowsToBeAdded);
        return rowsToBeAdded;
    }

    private void addPrimaryKeyRow(Table table, Row row, List<Column> columns) {
        String primaryKeyName = table.getPrimaryKey();
        Object primaryKeyValue = null;
        for(Column column : columns){
            if(column.getName().equals(primaryKeyName)){
                primaryKeyValue = column.getValue();
            }
        }
        Map<Object, Row> primaryKeyMap = table.getPrimaryKeyMap();
        if(primaryKeyMap == null){
            primaryKeyMap = new HashMap<>();
        }
        primaryKeyMap.put(primaryKeyValue, row);
        table.setPrimaryKeyMap(primaryKeyMap);
    }

    private void validateValuesToBeAdded(Table table, Map<String, List<Column>> valuesToBeInserted) {
        List<String> columnNames = table.getColumns().stream().map(Column::getName).toList();

        // check if all column exist in table or not
        for(String recordKey : valuesToBeInserted.keySet()){
            List<Column> inputColumnList = valuesToBeInserted.get(recordKey);
            for(Column column : inputColumnList){
                if(!columnNames.contains(column.getName())){
                    throw new RuntimeException("Invalid column name found in : {} " + recordKey);
                }
            }
        }

        // check datatype of values given by user
        for(String recordKey : valuesToBeInserted.keySet()){
            List<Column> inputColumnList = valuesToBeInserted.get(recordKey);
            for(Column inputColumn : inputColumnList){
                DataType inputColumnDataType = getColumnDataType(inputColumn.getName(), table);
                if(!isTypeCompatible(inputColumn.getValue(), inputColumnDataType)){
                    throw new RuntimeException("Invalid records found to be added.");
                }
            }
        }

    }

    private boolean isTypeCompatible(Object value, DataType dataType) {
        if (value == null) return true;
        return switch (dataType) {
            case STRING -> value instanceof String;
            case INTEGER -> value instanceof Integer;
            case DATE -> value instanceof Date;
            default -> false;
        };
    }

    private DataType getColumnDataType(String columnName, Table table){
        List<Column> columnList = table.getColumns();
        for(Column column : columnList){
            if(columnName.equals(column.getName())){
                return column.getDataType();
            }
        }
        throw new RuntimeException("ColumnName not found in table : {} " + columnName);
    }

    private boolean checkIfTableExist(List<Table> tableList, String tableName) {
        return tableList.stream().anyMatch(table -> table.getTableName().equals(tableName));
    }

    private Table getTableFromList(List<Table> tableList, String tableName) {
        for(Table table : tableList){
            if(table.getTableName().equals(tableName)){
                return table;
            }
        }
        throw new RuntimeException("Table Not Found in the list with name : {} " + tableName);
    }
}
