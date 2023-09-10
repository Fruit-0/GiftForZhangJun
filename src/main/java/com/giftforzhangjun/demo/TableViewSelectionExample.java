package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewSelectionExample extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX TableView Selection Example");
        
        TableView<Person> tableView = new TableView<>();
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // 设置选择模式为单选
        
        // 创建列
        TableColumn<Person, String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Person, String> lastNameColumn = new TableColumn<>("Last Name");
        
        // 将列添加到表格视图
        tableView.getColumns().addAll(firstNameColumn, lastNameColumn);
        
        // 创建数据
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("John", "Doe"),
                new Person("Jane", "Smith"),
                new Person("Bob", "Johnson")
        );
        
        // 设置数据源
        tableView.setItems(data);
        
        // 将数据绑定到列
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        // 处理选中事件
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String selectedFirstName = newSelection.getFirstName();
                String selectedLastName = newSelection.getLastName();
                System.out.println("Selected: " + selectedFirstName + " " + selectedLastName);
            }
        });
        
        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
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
        
        public String getLastName() {
            return lastName.get();
        }
        
        public SimpleStringProperty lastNameProperty() {
            return lastName;
        }
    }
}
