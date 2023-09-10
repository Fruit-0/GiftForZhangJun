package com.giftforzhangjun.utils;

import java.sql.*;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName DateBaseUtil.java
 * @Description TODO
 * @createTime 2023年09月11日 00:40:00
 */
public class DateBaseUtil {
    /**
     * URL地址
     */
    private static final String URL = "jdbc:mysql://192.168.56.10:3306/zhangjun_datebase?useSSL=false";
    /**
     * 登录数据库服务器的账号
     */
    private static final String USER = "root";
    /**
     * 登录数据库服务器的密码
     */
    private static final String PASSWORD = "123456";
    
    
    /**
     * @Description: 获取一个数据库链接
     * @Author: 冲动火龙果
     * @Date: 2023/9/11 0:43
     
     * @return: java.sql.Connection
     **/
    public static Connection getConn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    
    
    /**
     * 关闭资源
     *
     * @param rs
     * @param stat
     * @param conn
     */
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
}
