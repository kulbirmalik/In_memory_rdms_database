import model.Column;
import model.Database;
import model.Table;
import model.enums.DataType;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        DatabaseManager databaseManager = new DatabaseManager();
        Database database = databaseManager.createDatabase("Db1");
        System.out.println("Database created Successfully ----- " + database.getDatabaseName());

        // Create Table with initial schema
        List<Column> initialColumns = Arrays.asList(new Column("id", DataType.INTEGER)
                ,new Column("name", DataType.STRING)
                ,new Column("age", DataType.STRING));

        Table table = database.createTable("table1", "id", initialColumns);
        System.out.println("Table created Successfully ----- " + table.getTableName());

        Map<String, Object> values = new HashMap<>();
        values.put("id", 1);
        values.put("name", "Kulbir");
        values.put("age", "25");
        table.insertData(values);
        System.out.println("Data Inserted Successfully ----- " + table.getRows().toString());
    }
}