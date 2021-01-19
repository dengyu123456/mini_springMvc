package com.dy.databasedemo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dy.databasedemo.core.Cell;
import com.dy.databasedemo.core.Row;
import com.dy.databasedemo.core.RowSet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Write {
//    public static RowSet readFileByRowSet(String fileName, int limit) {
//
//    }

    /**
     * 58          * 使用BufferedWriter类写文本文件
     * 59
     */
    public static void writeMethod3(String fileName, RowSet rowSet) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
            for (Row row : rowSet.getRows()) {
                out.newLine();
                out.write(JSONArray.toJSONString(row));
            }
            out.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String filename = "C:\\Users\\root\\Desktop\\study\\mini_springMvc\\src\\main\\java\\com\\dy\\databasedemo\\student.txt";
        Cell cell1 = new Cell();
        cell1.setCellName("id");
        cell1.setSize("4");
        cell1.setType("int");
        cell1.setVal("1000");
        Row row1 = new Row();
        List<Cell> cells = new ArrayList<>();
        cells.add(cell1);
        row1.setCells(cells);

        Cell cell2 = new Cell();
        cell2.setCellName("id");
        cell2.setSize("4");
        cell2.setType("int");
        cell2.setVal("1001");
        Row row2 = new Row();
        List<Cell> cells2 = new ArrayList<>();
        cells2.add(cell2);
        row2.setCells(cells2);

        List<Row> rows=new ArrayList<>();
        RowSet rowSet=new RowSet();
        rows.add(row1);
        rows.add(row2);
        rowSet.setRows(rows);
        writeMethod3(filename, rowSet);
    }
}
