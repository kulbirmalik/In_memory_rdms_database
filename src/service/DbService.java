package service;

import model.Database;

public interface DbService {

    boolean checkIfDatabaseExist(String databaseName);

    Database createDatabase(String databaseName);

    void removeDatabase(String databaseName);
}
