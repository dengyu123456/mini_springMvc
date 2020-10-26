package com.dy.databasedemo.operator;

import com.dy.databasedemo.core.RowSet;

import java.util.Map;

//执行器基类
//所有执行器保证一个原则  输入一个RowSet  返回一个RowSet 由解析器来分析语法选择不同的执行器
public interface UnaryOperator {
    RowSet operator(RowSet rowSet, String[] args);
}
