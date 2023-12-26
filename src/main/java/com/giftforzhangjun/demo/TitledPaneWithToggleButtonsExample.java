package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TitledPaneWithToggleButtonsExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TitledPane 示例");
        
        // 创建一个垂直布局
        VBox root = new VBox(0); // 0 间距
        
        // 创建多个 TitledPane
        TitledPane titledPane1 = createTitledPane("面板1", createToggleButtonGroup());
        TitledPane titledPane2 = createTitledPane("面板2", createToggleButtonGroup());
        TitledPane titledPane3 = createTitledPane("面板3", createToggleButtonGroup());
        
        // 添加 TitledPane 到布局
        root.getChildren().addAll(titledPane1, titledPane2, titledPane3);
        
        // 创建一个 Scene，并将布局添加到其中
        Scene scene = new Scene(root, 400, 400);
        
        // 将 Scene 设置到 Stage
        primaryStage.setScene(scene);
        
        // 显示 Stage
        primaryStage.show();
    }
    
    // 辅助方法，创建一个 TitledPane 包含 ToggleButton 组
    private TitledPane createTitledPane(String title, VBox content) {
        // 创建一个 TitledPane，并设置标题和内容
        TitledPane titledPane = new TitledPane(title, content);
        
        // 设置 TitledPane 是否默认展开
        titledPane.setExpanded(false);
        
        // 设置 TitledPane 是否可折叠
        titledPane.setCollapsible(true);
        
        // 设置 HBox 的子节点宽度属性为 Priority.ALWAYS，使 ToggleButton 跟随 TitledPane 宽度
        HBox.setHgrow(content, Priority.ALWAYS);
        
        return titledPane;
    }
    
    // 辅助方法，创建一个包含多个 ToggleButton 的 VBox
    private VBox createToggleButtonGroup() {
        VBox content = new VBox(0); // 0 间距
        content.setPadding(new Insets(0)); // 零边距
        ToggleGroup toggleGroup = new ToggleGroup();
        
        for (int i = 1; i <= 3; i++) {
            ToggleButton toggleButton = new ToggleButton("按钮" + i);
            toggleButton.setToggleGroup(toggleGroup);
            toggleButton.setMinWidth(Control.USE_PREF_SIZE); // 设置最小宽度
            toggleButton.setMaxWidth(Double.MAX_VALUE); // 设置最大宽度
            content.getChildren().add(toggleButton);
        }
        
        return content;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
