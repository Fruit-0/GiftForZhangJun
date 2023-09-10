package com.giftforzhangjun.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName CommonTableSql.java
 * @Description TODO
 * @createTime 2023年09月11日 00:55:00
 */
public class CommonTableSql {
    
    
    public static String getTableColumnComment(String tableName, String columnName) {
        String columnComment = "字段名称映射错误！";
        tableName = tableName.toLowerCase();
        // 获取指定表的指定字段的中文注释
        String sqlStr = "select column_comment from information_schema.columns where table_name = '" + tableName + "' and column_name = '" + columnName + "'";
        try {
            PreparedStatement pstmt = DateBaseUtil.getConn().prepareStatement(sqlStr);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                columnComment = rs.getString("column_comment");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return columnComment;
    }
    
    /**
     * @Description: camelCase -> snake_case   "MyVariableName"; // 输出 "my_variable_name"
     * @Author: 冲动火龙果
     * @Date: 2023/9/11 1:08
     * @param camelCase:
     * @return: java.lang.String
     **/
    public static String convertCamelToSnake(String camelCase) {
        return camelCase.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
    
    
}
