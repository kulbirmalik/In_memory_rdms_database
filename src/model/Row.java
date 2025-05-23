package model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Row {
    private UUID rowId;
    private List<Column> columns;
    private Date createdAt;
    private Date modifiedAt;

    public UUID getRowId() {
        return rowId;
    }

    @Override
    public String toString() {
        return "Row{" +
                "rowId=" + rowId +
                ", columns=" + columns +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

    public void setRowId(UUID rowId) {
        this.rowId = rowId;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
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
