package com.dy.databasedemo.core;

//单元格
public class Cell {
    private String cellName;
    private String type;
    private String size;
    private String val;

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName == null ? null : cellName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cellName='" + cellName + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
