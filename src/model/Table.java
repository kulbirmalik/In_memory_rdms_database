package model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Table {
    private String tableName;
    private String primaryKey;
    private List<Row> rows;
    private List<Column> columns;
    private List<Column> secondaryIndexes;
    private Map<Object,Row> primaryKeyMap;
    private Map<String,Map<String,Row>> secondaryKeyMap;

    public Map<Object, Row> getPrimaryKeyMap() {
        return primaryKeyMap;
    }

    public void setPrimaryKeyMap(Map<Object, Row> primaryKeyMap) {
        this.primaryKeyMap = primaryKeyMap;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", primaryKey='" + primaryKey + '\'' +
                ", rows=" + rows +
                ", columns=" + columns +
                ", secondaryIndexes=" + secondaryIndexes +
                ", primaryKeyMap=" + primaryKeyMap +
                ", secondaryKeyMap=" + secondaryKeyMap +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

    public Map<String, Map<String, Row>> getSecondaryKeyMap() {
        return secondaryKeyMap;
    }

    public void setSecondaryKeyMap(Map<String, Map<String, Row>> secondaryKeyMap) {
        this.secondaryKeyMap = secondaryKeyMap;
    }

    private Date createdAt;
    private Date modifiedAt;

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

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
