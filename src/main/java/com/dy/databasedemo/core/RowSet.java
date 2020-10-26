package com.dy.databasedemo.core;

import java.util.List;

//每一个结果集由一系列row组成
public class RowSet {
    List<Row> rows;

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return rows.toString();
    }
}
