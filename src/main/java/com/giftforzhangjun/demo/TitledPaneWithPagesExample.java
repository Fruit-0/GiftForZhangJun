package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TitledPaneWithPagesExample extends Application {
    
    private BorderPane borderPane;
    private VBox leftPane;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TitledPane 示例");
        
        // 创建一个 BorderPane 布局
        borderPane = new BorderPane();
        
        // 创建左侧的 VBox，用于放置 TitledPane
        leftPane = new VBox(10);
        leftPane.setPadding(new Insets(10));
        
        // 创建多个 TitledPane
        TitledPane titledPane1 = createTitledPane("面板1", createToggleButtonGroup("页面1"));
        TitledPane titledPane2 = createTitledPane("面板2", createToggleButtonGroup("页面2"));
        TitledPane titledPane3 = createTitledPane("面板3", createToggleButtonGroup("页面3"));
        
        // 添加 TitledPane 到左侧 VBox
        leftPane.getChildren().addAll(titledPane1, titledPane2, titledPane3);
        
        // 添加左侧 VBox 到 BorderPane 的左侧
        borderPane.setLeft(leftPane);
        
        // 创建一个初始页面
        VBox initialPage = new VBox();
        initialPage.getChildren().add(new Label("这是初始页面"));
        
        // 将初始页面添加到 BorderPane 的右侧
        borderPane.setCenter(initialPage);
        
        // 创建一个 Scene，并将 BorderPane 添加到其中
        Scene scene = new Scene(borderPane, 600, 400);
        
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
        
        return titledPane;
    }
    
    // 辅助方法，创建一个包含多个 ToggleButton 的 VBox
    private VBox createToggleButtonGroup(String pageName) {
        VBox content = new VBox(0); // 0 间距
        content.setPadding(new Insets(0)); // 零边距
        ToggleGroup toggleGroup = new ToggleGroup();
        
        for (int i = 1; i <= 3; i++) {
            ToggleButton toggleButton = new ToggleButton("按钮" + i);
            toggleButton.setToggleGroup(toggleGroup);
            toggleButton.setMinWidth(Control.USE_PREF_SIZE); // 设置最小宽度
            toggleButton.setMaxWidth(Double.MAX_VALUE); // 设置最大宽度
            
            // 添加事件处理器，以显示不同的页面
            int finalI = i;
            toggleButton.setOnAction(e -> displayPage(pageName + " - 按钮" + finalI));
            
            content.getChildren().add(toggleButton);
        }
        
        return content;
    }
    
    // 辅助方法，显示不同的页面
    private void displayPage(String pageName) {
        // 创建一个新的页面
        VBox page = new VBox();
        page.getChildren().add(new Label("这是 " + pageName + " 页面"));
        
        // 将新页面添加到 BorderPane 的右侧
        borderPane.setCenter(page);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
