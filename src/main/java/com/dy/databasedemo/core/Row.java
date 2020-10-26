package com.dy.databasedemo.core;

import java.util.List;

//每一行是由一系列单元格组成
public class Row {
    List<Cell> cells;

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return cells.toString();
    }
}
