package model;

import java.util.*;


public class Database {

    private String databaseName;
    private Map<String, Table> tableMap;
    private Date createAt;
    private Date updatedAt;

    public Database(String databaseName){
        this.databaseName = databaseName;
        this.tableMap = new HashMap<>();
        this.createAt = new Date();
        this.updatedAt = new Date();
    }

    public Table createTable(String tableName, String primaryKey, List<Column> columns){
        if(tableMap.containsKey(tableName)){
            System.out.println("Table with the given name already exists.");
        }
        Table table = new Table(tableName, primaryKey, columns);
        tableMap.put(tableName, table);
        return table;
    }

    public String getDatabaseName(){
        return this.databaseName;
    }
}
