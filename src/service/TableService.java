package service;

import model.Column;
import model.Row;
import model.Table;
import model.TableCreateRequest;

import java.util.List;
import java.util.Map;

public interface TableService {

    Table createTableDefinition(TableCreateRequest tableCreateRequest);

    Table updateTableDefinition();

    void removeTableDefinition(String tableName);

    List<Row> addDataToTable(String databaseName, String tableName, Map<String, List<Column>> valuesToBeInserted);
}
