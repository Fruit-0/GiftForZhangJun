package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class TableViewExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // 创建一个 TableView 控件
        TableView<Person> tableView = new TableView<>();
        
        // 创建表格列
        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        
        // 设置表格列与数据模型的关联
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // 设置单元格工厂，允许文本选择和复制
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        // 创建数据集合
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.addAll(
                new Person("John", "Doe"),
                new Person("Jane", "Smith"),
                new Person("Bob", "Johnson")
        );
        
        // 将数据集合设置给 TableView
        tableView.setItems(people);
        
        // 将表格列添加到 TableView 中
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn);
        
        // 创建场景并显示
        Scene scene = new Scene(tableView, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static class Person {
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        
        public Person(String firstName, String lastName) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
        }
        
        public String getFirstName() {
            return firstName.get();
        }
        
        public SimpleStringProperty firstNameProperty() {
            return firstName;
        }
        
        public void setFirstName(String firstName) {
            this.firstName.set(firstName);
        }
        
        public String getLastName() {
            return lastName.get();
        }
        
        public SimpleStringProperty lastNameProperty() {
            return lastName;
        }
        
        public void setLastName(String lastName) {
            this.lastName.set(lastName);
        }
    }
}
