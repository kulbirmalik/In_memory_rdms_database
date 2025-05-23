import model.*;
import model.enums.DataType;
import service.DbService;
import service.TableService;
import service.impl.DbServiceImpl;
import service.impl.TableServiceImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        DbService dbService = new DbServiceImpl();
        Database database = dbService.createDatabase("db1");
        System.out.println("Database created successfully : " + database);

        TableService tableService = new TableServiceImpl(dbService);
        List<Column> columnList = Arrays.asList(new Column("id", DataType.INTEGER),
                new Column("name", DataType.STRING), new Column("age", DataType.INTEGER));
        TableCreateRequest tableCreateRequest = new TableCreateRequest();
        tableCreateRequest.setDatabaseName("db1");
        tableCreateRequest.setTableName("table1");
        tableCreateRequest.setPrimaryKey("id");
        tableCreateRequest.setColumns(columnList);
        Table table = tableService.createTableDefinition(tableCreateRequest);
        System.out.println("Table created successfully : " + table);

        Map<String, List<Column>> valuesToBeAdded = new HashMap<>();
        valuesToBeAdded.put("record1", Arrays.asList(new Column("id", 1), new Column("name", "kulbir"), new Column("age", 25)));
        valuesToBeAdded.put("record2", Arrays.asList(new Column("id", 2), new Column("name", "radhika"), new Column("age", 26)));

        List<Row> rowsAdded =  tableService.addDataToTable("db1", "table1", valuesToBeAdded);
        System.out.println("Successfully added records : " + rowsAdded);
    }

}
