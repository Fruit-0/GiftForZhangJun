package com.giftforzhangjun.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * @Description:  可折叠的面板
 *
 *
 * TitledPane 是 JavaFX 中的一个 UI 控件，
 * 它是一个可折叠的面板，通常包含一个标题和一个内容区域。
 * 用户可以单击标题来展开或折叠内容区域，这对于创建可折叠的面板或折叠菜单非常有用。
 * @Author: 冲动火龙果
 * @Date: 2023/9/16 21:02
 * @param null:
 * @return: null
 **/
public class TitledPaneExample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TitledPane 示例");
        
        // 创建一个垂直布局
        VBox root = new VBox();
        
        // 创建多个 TitledPane
        TitledPane titledPane1 = createTitledPane("面板1", createContent());
        TitledPane titledPane2 = createTitledPane("面板2", createContent());
        TitledPane titledPane3 = createTitledPane("面板3", createContent());
        
        // 添加 TitledPane 到布局
        root.getChildren().addAll(titledPane1, titledPane2, titledPane3);
        
        // 创建一个 Scene，并将布局添加到其中
        Scene scene = new Scene(root, 400, 400);
        
        // 将 Scene 设置到 Stage
        primaryStage.setScene(scene);
        
        // 显示 Stage
        primaryStage.show();
    }
    
    // 辅助方法，创建一个 TitledPane
    private TitledPane createTitledPane(String title, VBox content) {
        // 创建一个 TitledPane，并设置标题和内容
        TitledPane titledPane = new TitledPane(title, content);
        
        // 设置 TitledPane 是否默认展开
        titledPane.setExpanded(false);
        
        // 设置 TitledPane 是否可折叠
        titledPane.setCollapsible(true);
        // 设置展开和折叠的动画速度
        Timeline animationTimeline = new Timeline(
                new KeyFrame(Duration.millis(200), e -> { // 调整展开速度
                    titledPane.setAnimated(true);
                }),
                new KeyFrame(Duration.millis(500), e -> { // 调整折叠速度
                    titledPane.setAnimated(true);
                })
        );
        animationTimeline.setCycleCount(1);
        animationTimeline.play();
        
        return titledPane;
    }
    
    // 辅助方法，创建一个包含多个内容项的 VBox
    private VBox createContent() {
        VBox content = new VBox(5); // 使用 VBox 包含多个内容项
        content.getChildren().addAll(
                new Label("内容项1"),
                new Label("内容项2"),
                new Label("内容项3"),
                new Button("按钮1"),
                new Button("按钮2"),
                new Button("按钮3")
        );
        return content;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
