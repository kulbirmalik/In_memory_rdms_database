package model;


import java.util.*;

public class Row {

    private UUID rowId;
    private List<Column> columns;
    private Date createdAt;
    private Date updatedAt;

    public Row(){
        this.rowId = UUID.randomUUID();
        this.columns = new ArrayList<>();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public void addColumnValues(Map<String, Object> values) {
        for(String key : values.keySet()){
            columns.add(new Column(key, values.get(key)));
        }
    }

    public List<Column> getColumns() {
        return this.columns;
    }

    @Override
    public String toString(){
        return rowId.toString() + " --- " + columns.toString() + " --- " + createdAt + " --- " + updatedAt;
    }

}
