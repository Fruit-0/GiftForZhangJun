package com.giftforzhangjun.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TitledPaneWithStyledToggleButtonsAndPages extends Application {
    
    private BorderPane borderPane;
    private VBox leftPane;
    private VBox rightPane;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TitledPane 示例");
        
        // 创建一个 BorderPane 布局
        borderPane = new BorderPane();
        
        // 创建分割线
        SplitPane splitPane = new SplitPane();
        splitPane.setStyle("-fx-divider-position: 0.2;"); // 设置分割线位置
        // 创建左侧的 VBox，用于放置 TitledPane
        leftPane = new VBox();
        leftPane.setPadding(new Insets(0));
        
        // 创建多个 TitledPane
        TitledPane titledPane1 = createTitledPane("面板1", createToggleButtonGroup("页面1"));
        TitledPane titledPane2 = createTitledPane("面板2", createToggleButtonGroup("页面2"));
        TitledPane titledPane3 = createTitledPane("面板3", createToggleButtonGroup("页面3"));
        
        // 添加 TitledPane 到左侧 VBox
        leftPane.getChildren().addAll(titledPane1, titledPane2, titledPane3);
        
        // 将左侧 VBox 添加到分割线的左侧
        splitPane.getItems().add(leftPane);
        
        // 创建右侧的 VBox，用于显示页面内容
        rightPane = new VBox();
        rightPane.setPadding(new Insets(10));
        rightPane.getChildren().add(new Label("这是初始页面"));
        
        // 将右侧 VBox 添加到分割线的右侧
        splitPane.getItems().add(rightPane);
        
        // 设置分割线的位置
        splitPane.setDividerPositions(0.2);
        
        // 添加分割线到 BorderPane 的中间
        borderPane.setCenter(splitPane);
        
        // 创建一个 Scene，并将 BorderPane 添加到其中
        Scene scene = new Scene(borderPane, 800, 400);
        
        // 内联 CSS 样式定义
        String inlineCSS =
                ".toggle-button {" +
                        "    -fx-background-color: transparent;" +
                        "    -fx-background-radius: 0;" +
                        "    -fx-border-color: transparent;" +
                        "    -fx-padding: 0.5em 0.7em;" +
                        "    -fx-alignment: center-right;" +
                        "}" +
                        ".toggle-button:selected {" +
                        "    -fx-background-color: white;" +
                        "}" +
                        ".toggle-button:selected:focused {" +
                        "    -fx-background-color: lightblue;" +
                        "}";
        
        // 将内联 CSS 样式应用到 Scene
        scene.getStylesheets().add("data:text/css," + inlineCSS);
        
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
        // 清空右侧的内容
        rightPane.getChildren().clear();
        
        // 创建一个新的页面
        VBox page = new VBox();
        page.getChildren().add(new Label("这是 " + pageName + " 页面"));
        
        // 将新页面添加到右侧 VBox
        rightPane.getChildren().add(page);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
