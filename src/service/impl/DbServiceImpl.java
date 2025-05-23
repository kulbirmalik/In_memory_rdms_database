package service.impl;

import model.Database;
import service.DbService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DbServiceImpl implements DbService {

    private Map<String, Database> databaseMap;

    public DbServiceImpl(){
        this.databaseMap = new HashMap<>();
    }

    @Override
    public boolean checkIfDatabaseExist(String databaseName) {
        return databaseMap.containsKey(databaseName);
    }

    @Override
    public Database createDatabase(String databaseName) {
        Database database = new Database();
        database.setName(databaseName);
        database.setCreatedAt(new Date());
        database.setModifiedAt(new Date());
        databaseMap.put(databaseName, database);
        return database;
    }

    @Override
    public void removeDatabase(String databaseName) {

    }
}
