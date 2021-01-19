package com.dy.databasedemo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONReader;
import com.dy.databasedemo.core.Cell;
import com.dy.databasedemo.core.Row;
import com.dy.databasedemo.core.RowSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Read {
    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static RowSet readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        RowSet rowSet = new RowSet();
        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String rowString = null;
            int line = 1;
            List<Row> rows = new ArrayList<>();
            // 一次读入一行，直到读入null为文件结束
            while ((rowString = reader.readLine()) != null) {
                List<Cell> cells = JSONArray.parseArray(rowString, Cell.class);
                Row row = new Row();
                row.setCells(cells);
                rows.add(row);
                line++;
            }
            rowSet.setRows(rows);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return rowSet;
    }

    public static RowSet readFileByLines(String fileName, int limit) {
        File file = new File(fileName);
        BufferedReader reader = null;
        RowSet rowSet = new RowSet();
        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String rowString = null;
            int line = 1;
            List<Row> rows = new ArrayList<>();
            // 一次读入一行，直到读入null为文件结束
            while ((rowString = reader.readLine()) != null && line <= limit) {
                Row row = JSONArray.parseObject(rowString, Row.class);
                //Row row = (Row) JSONArray.parseArray(rowString, Row.class);
//                Row row = new Row();
//                row.setCells(cells);
                rows.add(row);
                line++;

//                List<Cell> cells = JSONArray.parseArray(rowString, Cell.class);
//                Row row = new Row();
//                row.setCells(cells);
//                rows.add(row);
//                line++;
            }
            rowSet.setRows(rows);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return rowSet;
    }

}
