package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BiologicalDirectoryApp extends Application {
    private Connection connection;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Biological Directory");
        
        // 创建数据库连接
        connectToDatabase();
        
        TableView<BiologicalRecord> tableView = new TableView<>();
        tableView.setEditable(true);
        
        // 创建表格列
        TableColumn<BiologicalRecord, String> kingdomColumn = createColumn("Kingdom CN", "KINGDOM_CN");
        // 创建其他列...
        
        tableView.getColumns().addAll(kingdomColumn /*, 其他列... */);
        
        // 创建增加、删除、修改、查询的控件
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        Button updateButton = new Button("Update");
        TextField searchField = new TextField();
        Button searchButton = new Button("Search");
        
        addButton.setOnAction(e -> addRecord(tableView));
        deleteButton.setOnAction(e -> deleteRecord(tableView));
        updateButton.setOnAction(e -> updateRecord(tableView));
        searchButton.setOnAction(e -> searchRecords(tableView, searchField.getText()));
        
        HBox controlBox = new HBox(addButton, deleteButton, updateButton, searchField, searchButton);
        
        VBox vbox = new VBox(controlBox, tableView);
        Scene scene = new Scene(vbox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/your_database_name?useUnicode=true&characterEncoding=utf8";
            String user = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private TableColumn<BiologicalRecord, String> createColumn(String columnName, String propertyName) {
        TableColumn<BiologicalRecord, String> column = new TableColumn<>(columnName);
        column.setCellValueFactory(cellData -> cellData.getValue().getProperty(propertyName));
        return column;
    }
    
    private void addRecord(TableView<BiologicalRecord> tableView) {
        // 实现添加记录的逻辑
    }
    
    private void deleteRecord(TableView<BiologicalRecord> tableView) {
        // 实现删除记录的逻辑
    }
    
    private void updateRecord(TableView<BiologicalRecord> tableView) {
        // 实现更新记录的逻辑
    }
    
    private void searchRecords(TableView<BiologicalRecord> tableView, String keyword) {
        // 实现查询记录的逻辑
    }
    
    @Override
    public void stop() {
        // 关闭数据库连接
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static class BiologicalRecord {
        private final SimpleStringProperty KINGDOM_CN;
        
        public BiologicalRecord(String kingdomCN) {
            this.KINGDOM_CN = new SimpleStringProperty(kingdomCN);
        }
        
        public SimpleStringProperty getProperty(String propertyName) {
            if (propertyName.equals("KINGDOM_CN")) {
                return KINGDOM_CN;
            }
            // 处理其他属性...
            
            return null;
        }
    }
}
