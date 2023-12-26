package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * @Description:
 *
 *
         * ToggleButton 是 JavaFX 中的一个 UI 控件，它是一个具有两个状态的按钮，
         * 可以在选中和未选中状态之间切换。通常，ToggleButton 用于启用或禁用某个功能或选项。
         * 用户可以单击 ToggleButton 来切换其状态。
 * @Author: 冲动火龙果
 * @Date: 2023/9/16 21:07
 * @param null:
 * @return: null
 **/
public class ToggleButtonExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ToggleButton 示例");
        
        // 创建一个垂直布局
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        
        // 创建一个标签来显示 ToggleButton 的状态
        Label statusLabel = new Label("状态：未选中");
        
        // 创建一个 ToggleButton
        ToggleButton toggleButton = new ToggleButton("切换状态");
        
        // 添加事件处理器，以便在点击 ToggleButton 时更新标签的文本
        toggleButton.setOnAction(e -> {
            if (toggleButton.isSelected()) {
                statusLabel.setText("状态：已选中");
            } else {
                statusLabel.setText("状态：未选中");
            }
        });
        
        // 创建一个 CheckBox，用于控制 ToggleButton 的禁用状态
        CheckBox disableCheckBox = new CheckBox("禁用 ToggleButton");
        disableCheckBox.setOnAction(e -> {
            toggleButton.setDisable(disableCheckBox.isSelected());
        });
        
        // 添加控件到布局
        root.getChildren().addAll(statusLabel, toggleButton, disableCheckBox);
        
        // 创建一个 Scene，并将布局添加到其中
        Scene scene = new Scene(root, 300, 200);
        
        // 将 Scene 设置到 Stage
        primaryStage.setScene(scene);
        
        // 显示 Stage
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
