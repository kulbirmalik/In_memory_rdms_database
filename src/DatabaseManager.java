import model.Database;

import java.util.HashMap;
import java.util.Map;

// responsible for creating, removing and maintaining databases
public class DatabaseManager {

    private Map<String, Database> databaseMap;

    public DatabaseManager() {
        this.databaseMap = new HashMap<>();
    }

    public Database createDatabase(String name){
        if(databaseMap.containsKey(name)){
            System.out.println("Database with given name already exists.");
        }
        Database database = new Database(name);
        databaseMap.put(name, database);
        return database;
    }

    public Database removeDatabase(String name){
        if(!databaseMap.containsKey(name)){
            System.out.println("Database with given name do not exist.");
        }
        Database database = databaseMap.get(name);
        databaseMap.remove(name);
        return database;
    }


}
