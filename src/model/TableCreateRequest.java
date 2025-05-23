package model;

import java.util.List;

public class TableCreateRequest {
    private String databaseName;
    private String tableName;
    private String primaryKey;
    private List<Column> columns;
    private List<Column> secondaryIndexes;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Column> getSecondaryIndexes() {
        return secondaryIndexes;
    }

    public void setSecondaryIndexes(List<Column> secondaryIndexes) {
        this.secondaryIndexes = secondaryIndexes;
    }
}
