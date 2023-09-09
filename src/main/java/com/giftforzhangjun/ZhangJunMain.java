package com.giftforzhangjun;

import com.giftforzhangjun.tableModel.BiologicalDirectory;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ZhangJunMain extends Application {
    private static Stage stage;
    
    private static int anum = 0;
    private static int number = 0;
    private static Student student0;
    
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
//      给窗口赋予静态属性
        ZhangJunMain.stage = stage;
        // 设置窗口不可调
        stage.setResizable(false);
        normalStage();
        stage.show();
    }
    
    
    /**
     * @Description: 最基础的查询主页面
     * @Author: 冲动火龙果
     * @Date: 2023/9/9 22:54
     * @return: void
     **/
    public static void normalStage() {
        // 基本属性设置-----------START
        BorderPane bp = new BorderPane();
        stage.setTitle("张俊是个好同志");
        Scene sc = new Scene(bp, 1500, 800);
        stage.setScene(sc);
        stage.show();
        // 基本属性设置-----------END
        
        //  查询条件框
        FlowPane fp1 = new FlowPane();
        Label name = new Label("姓名");
        TextField nameValue = new TextField();
        Label className = new Label("班级");
        TextField classNameValue = new TextField();
        fp1.getChildren().addAll(name, nameValue, className, classNameValue);
        fp1.setHgap(15);
        fp1.setPadding(new Insets(20));
        
        // 操作功能框
        FlowPane fp2 = new FlowPane();
        Button queryButton = new Button("查询");
        Button addButton = new Button("增加");
        Button deleteButton = new Button("删除");
        Button alterButton = new Button("修改");
        fp2.getChildren().addAll(queryButton, addButton, deleteButton, alterButton);
        fp2.setHgap(15);
        fp2.setPadding(new Insets(20));
        
        //  整合查询条件框和操作功能框
        VBox vBox = new VBox();
        vBox.getChildren().addAll(fp1, fp2);
        
        // 注册【查询】按钮的功能
        queryButton.setOnAction(a -> {
            if (!nameValue.getText().trim().equals("") && classNameValue.getText().trim().equals("")) {   // 姓名
                refer(nameValue.getText(), 1);
            } else if (nameValue.getText().trim().equals("") && !classNameValue.getText().trim().equals("")) {  // 班级
                refer(classNameValue.getText(), 2);
            } else if (!nameValue.getText().trim().equals("") && !classNameValue.getText().trim().equals("")) {  // 姓名+班级
                refer1(nameValue.getText(), classNameValue.getText());
            }
        });
        
        // 注册【添加】按钮的功能
        addButton.setOnAction(a -> {
            insertFunction(bp, stage);
        });
        
        // 注册【删除】按钮的功能
        deleteButton.setOnAction(a -> {
            deleteFunction(bp, stage);
        });
        
        // 注册【修改】按钮的功能
        alterButton.setOnAction(a -> {
            alterFunction(bp, stage);
        });
        
        bp.setTop(vBox);
        
        // 页面展示后进行一次默认的查询操作
        List<BiologicalDirectory> biologicalDirectoryList = new ArrayList<>();
        queryFucntion(bp, biologicalDirectoryList);
        
    }
    
    static void queryFucntion(BorderPane bp, List<BiologicalDirectory> biologicalDirectoryList) {
        //  定义表格对象
        TableView<BiologicalDirectory> tv = new TableView();
        
        // 定义表格的列
        TableColumn pkTc = new TableColumn("主键");
        // 表格列宽宽度设置
        pkTc.setMinWidth(50);
        // 设置列的内容水平居中
        pkTc.setCellValueFactory(new PropertyValueFactory<>("pk"));
        pkTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(pkTc);
        
        TableColumn kingdomCnTc = new TableColumn("界_中文名");
        kingdomCnTc.setMinWidth(50);
        kingdomCnTc.setCellValueFactory(new PropertyValueFactory<>("kingdomCn"));
        kingdomCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(kingdomCnTc);
        
        TableColumn kingdomLatinTc = new TableColumn("界_拉丁名");
        kingdomLatinTc.setMinWidth(50);
        kingdomLatinTc.setCellValueFactory(new PropertyValueFactory<>("kingdomLatin"));
        kingdomLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(kingdomLatinTc);
        
        TableColumn phylumCnTc = new TableColumn("门_中文名");
        phylumCnTc.setMinWidth(50);
        phylumCnTc.setCellValueFactory(new PropertyValueFactory<>("phylumCn"));
        phylumCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(phylumCnTc);
        
        TableColumn phylumLatinTc = new TableColumn("门_拉丁名");
        phylumLatinTc.setMinWidth(50);
        phylumLatinTc.setCellValueFactory(new PropertyValueFactory<>("phylumLatin"));
        phylumLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(phylumLatinTc);
        
        TableColumn classCnTc = new TableColumn("纲_中文名");
        classCnTc.setMinWidth(50);
        classCnTc.setCellValueFactory(new PropertyValueFactory<>("classCn"));
        classCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(classCnTc);
        
        TableColumn classLatinTc = new TableColumn("纲_拉丁名");
        classLatinTc.setMinWidth(50);
        classLatinTc.setCellValueFactory(new PropertyValueFactory<>("classLatin"));
        classLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(classLatinTc);
        
        TableColumn orderCnTc = new TableColumn("目_中文名");
        orderCnTc.setMinWidth(50);
        orderCnTc.setCellValueFactory(new PropertyValueFactory<>("orderCn"));
        orderCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(orderCnTc);
        
        TableColumn orderLatinTc = new TableColumn("目_拉丁名");
        orderLatinTc.setMinWidth(50);
        orderLatinTc.setCellValueFactory(new PropertyValueFactory<>("orderLatin"));
        orderLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(orderLatinTc);
        
        TableColumn familyCnTc = new TableColumn("科_中文名");
        familyCnTc.setMinWidth(50);
        familyCnTc.setCellValueFactory(new PropertyValueFactory<>("familyCn"));
        familyCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(familyCnTc);
        
        TableColumn familyLatinTc = new TableColumn("科_拉丁名");
        familyLatinTc.setMinWidth(50);
        familyLatinTc.setCellValueFactory(new PropertyValueFactory<>("familyLatin"));
        familyLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(familyLatinTc);
        
        TableColumn genusCnTc = new TableColumn("属_中文名");
        genusCnTc.setMinWidth(50);
        genusCnTc.setCellValueFactory(new PropertyValueFactory<>("genusCn"));
        genusCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(genusCnTc);
        
        TableColumn genusLatinTc = new TableColumn("属_拉丁名");
        genusLatinTc.setMinWidth(50);
        genusLatinTc.setCellValueFactory(new PropertyValueFactory<>("genusLatin"));
        genusLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(genusLatinTc);
        
        TableColumn speciesCnTc = new TableColumn("种_中文名");
        speciesCnTc.setMinWidth(50);
        speciesCnTc.setCellValueFactory(new PropertyValueFactory<>("speciesCn"));
        speciesCnTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(speciesCnTc);
        
        TableColumn speciesLatinTc = new TableColumn("种_拉丁名");
        speciesLatinTc.setMinWidth(50);
        speciesLatinTc.setCellValueFactory(new PropertyValueFactory<>("speciesLatin"));
        speciesLatinTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(speciesLatinTc);
        
        TableColumn auditorTc = new TableColumn("审核人");
        auditorTc.setMinWidth(50);
        auditorTc.setCellValueFactory(new PropertyValueFactory<>("auditor"));
        auditorTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(auditorTc);
        
        TableColumn directoryVersionTc = new TableColumn("名录版本");
        directoryVersionTc.setMinWidth(50);
        directoryVersionTc.setCellValueFactory(new PropertyValueFactory<>("directoryVersion"));
        directoryVersionTc.setStyle("-fx-alignment: CENTER;");
        tv.getColumns().addAll(directoryVersionTc);
        
        try {
            // 将查询的结果封装到list中
            Link.magstudent(biologicalDirectoryList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tv.getItems().addAll(biologicalDirectoryList);
        bp.setCenter(tv);
    }
    
    
    //-------------------------------------------------------------------------
//    学生成绩表格
    
    
    //    --------------------------------------------------------------------
    //    名字模糊<<<<查询>>>>>表格--------------教师---查询学生----班级或姓名
    static void refer(String name, int squad) {
        BorderPane bp = new BorderPane();
        stage.setTitle("学校管理系统");
        Scene sc = new Scene(bp, 870, 450);
        stage.setScene(sc);
        stage.show();
        FlowPane fp1 = new FlowPane();
        Label l1 = new Label("名称");
        TextField f1 = new TextField();
        Label l2 = new Label("班级");
        TextField f2 = new TextField();
        Button b1 = new Button("查询");
        Button b2 = new Button("返回");
        ArrayList<Student> students = new ArrayList<>();
        // 学生成绩表格    //id查询后表格
        magin1(bp, students, name, squad);
        b1.setOnAction(a -> {
            if (!f1.getText().trim().equals("") && f2.getText().trim().equals("")) {   // 姓名
                refer(f1.getText(), 1);
            } else if (f1.getText().trim().equals("") && !f2.getText().trim().equals("")) {  // 班级
                refer(f2.getText(), 2);
            } else if (!f1.getText().trim().equals("") && !f2.getText().trim().equals("")) {  // 姓名+班级
                refer1(f1.getText(), f2.getText());
            }
        });
        b2.setOnAction(a -> {
            normalStage();
        });
        fp1.getChildren().addAll(l1, f1, l2, f2, b1, b2);
        fp1.setHgap(15);
        fp1.setPadding(new Insets(20));
        bp.setTop(fp1);
    }
    
    //    --------------------------------------------------------------------
    //    模糊<<<<查询>>>>>表格-----------教师---查询学生----班级和姓名
    static void refer1(String name, String squad) {
        BorderPane bp = new BorderPane();
        stage.setTitle("学校管理系统");
        Scene sc = new Scene(bp, 871, 450);
        stage.setScene(sc);
        stage.show();
        FlowPane fp1 = new FlowPane();
        Label l1 = new Label("名称");
        TextField f1 = new TextField();
        Label l2 = new Label("班级");
        TextField f2 = new TextField();
        Button b1 = new Button("查询");
        Button b2 = new Button("返回");
        ArrayList<Student> students = new ArrayList<>();
        // 学生成绩表格    //id查询后表格
        magin2(bp, students, name, squad);
        b1.setOnAction(a -> {
            if (!f1.getText().trim().equals("") && f2.getText().trim().equals("")) {   // 姓名
                refer(f1.getText(), 1);
            } else if (f1.getText().trim().equals("") && !f2.getText().trim().equals("")) {  // 班级
                refer(f2.getText(), 2);
            } else if (!f1.getText().trim().equals("") && !f2.getText().trim().equals("")) {  // 姓名+班级
                refer1(f1.getText(), f2.getText());
            }
        });
        b2.setOnAction(a -> {
            normalStage();
        });
        fp1.getChildren().addAll(l1, f1, l2, f2, b1, b2);
        fp1.setHgap(15);
        fp1.setPadding(new Insets(20));
        bp.setTop(fp1);
    }
    
    // 查询表格-------查询学生
//    ----------------------------------------------------------------------------
    public static void magin(BorderPane bp, ArrayList<Student> students, String xing) {
        TableView<Student> tv = new TableView();
        // 定义表格的行标
        TableColumn ID = new TableColumn("学号");
        TableColumn number = new TableColumn("班级");
        TableColumn name = new TableColumn("姓名");
        TableColumn sex = new TableColumn("性别");
        TableColumn code = new TableColumn("密码");
        TableColumn chinese = new TableColumn("语文");
        TableColumn mathematics = new TableColumn("数学");
        TableColumn english = new TableColumn("英语");
        TableColumn chemistry = new TableColumn("化学");
        TableColumn history = new TableColumn("历史");
        TableColumn peace = new TableColumn("总分");
        TableColumn compellation = new TableColumn("班主任");
        // 表格列宽宽度设置
        ID.setMinWidth(65);
        name.setMinWidth(72);
        number.setMinWidth(75);
        sex.setMinWidth(65);
        code.setMinWidth(74);
        chinese.setMinWidth(75);
        mathematics.setMinWidth(75);
        english.setMinWidth(75);
        chemistry.setMinWidth(75);
        history.setMinWidth(75);
        peace.setMinWidth(70);
        compellation.setMinWidth(70);
        
        // 确定数据导入的列
        ID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        number.setCellValueFactory(
                new PropertyValueFactory<>("number"));
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        sex.setCellValueFactory(
                new PropertyValueFactory<>("sex"));
        code.setCellValueFactory(
                new PropertyValueFactory<>("code"));
        chinese.setCellValueFactory(
                new PropertyValueFactory<>("chinese"));
        mathematics.setCellValueFactory(
                new PropertyValueFactory<>("mathematics"));
        english.setCellValueFactory(
                new PropertyValueFactory<>("english"));
        chemistry.setCellValueFactory(
                new PropertyValueFactory<>("chemistry"));
        history.setCellValueFactory(
                new PropertyValueFactory<>("history"));
        peace.setCellValueFactory(
                new PropertyValueFactory<>("peace"));
        compellation.setCellValueFactory(
                new PropertyValueFactory<>("compellation")
        );
        tv.getColumns().addAll(ID, number, name, sex, code, chinese, mathematics, english, chemistry, history, peace, compellation);
        try {
            Link.inquire(students, xing);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tv.getItems().addAll(students);
        bp.setCenter(tv);
    }
    
    // 查询表格-------查询学生
//    ----------------------------------------------------------------------------
    public static void magin1(BorderPane bp, ArrayList<Student> students, String xing, int a) {
        TableView<Student> tv = new TableView();
        // 定义表格的行标
        TableColumn ID = new TableColumn("学号");
        TableColumn number = new TableColumn("班级");
        TableColumn name = new TableColumn("姓名");
        TableColumn sex = new TableColumn("性别");
        TableColumn code = new TableColumn("密码");
        TableColumn chinese = new TableColumn("语文");
        TableColumn mathematics = new TableColumn("数学");
        TableColumn english = new TableColumn("英语");
        TableColumn chemistry = new TableColumn("化学");
        TableColumn history = new TableColumn("历史");
        TableColumn peace = new TableColumn("总分");
        TableColumn compellation = new TableColumn("班主任");
        // 表格列宽宽度设置
        ID.setMinWidth(65);
        name.setMinWidth(72);
        number.setMinWidth(75);
        sex.setMinWidth(65);
        code.setMinWidth(74);
        chinese.setMinWidth(75);
        mathematics.setMinWidth(75);
        english.setMinWidth(75);
        chemistry.setMinWidth(75);
        history.setMinWidth(75);
        peace.setMinWidth(70);
        compellation.setMinWidth(70);
        
        // 确定数据导入的列
        ID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        number.setCellValueFactory(
                new PropertyValueFactory<>("number"));
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        sex.setCellValueFactory(
                new PropertyValueFactory<>("sex"));
        code.setCellValueFactory(
                new PropertyValueFactory<>("code"));
        chinese.setCellValueFactory(
                new PropertyValueFactory<>("chinese"));
        mathematics.setCellValueFactory(
                new PropertyValueFactory<>("mathematics"));
        english.setCellValueFactory(
                new PropertyValueFactory<>("english"));
        chemistry.setCellValueFactory(
                new PropertyValueFactory<>("chemistry"));
        history.setCellValueFactory(
                new PropertyValueFactory<>("history"));
        peace.setCellValueFactory(
                new PropertyValueFactory<>("peace"));
        compellation.setCellValueFactory(
                new PropertyValueFactory<>("compellation")
        );
        tv.getColumns().addAll(ID, number, name, sex, code, chinese, mathematics, english, chemistry, history, peace, compellation);
        try {
            Link.inquire1(students, xing, a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tv.getItems().addAll(students);
        bp.setCenter(tv);
    }
    
    // 查询表格-------查询学生
//    ----------------------------------------------------------------------------
    public static void magin2(BorderPane bp, ArrayList<Student> students, String xing, String a) {
        TableView<Student> tv = new TableView();
        // 定义表格的行标
        TableColumn ID = new TableColumn("学号");
        TableColumn number = new TableColumn("班级");
        TableColumn name = new TableColumn("姓名");
        TableColumn sex = new TableColumn("性别");
        TableColumn code = new TableColumn("密码");
        TableColumn chinese = new TableColumn("语文");
        TableColumn mathematics = new TableColumn("数学");
        TableColumn english = new TableColumn("英语");
        TableColumn chemistry = new TableColumn("化学");
        TableColumn history = new TableColumn("历史");
        TableColumn peace = new TableColumn("总分");
        TableColumn compellation = new TableColumn("班主任");
        // 表格列宽宽度设置
        ID.setMinWidth(65);
        name.setMinWidth(72);
        number.setMinWidth(75);
        sex.setMinWidth(65);
        code.setMinWidth(74);
        chinese.setMinWidth(75);
        mathematics.setMinWidth(75);
        english.setMinWidth(75);
        chemistry.setMinWidth(75);
        history.setMinWidth(75);
        peace.setMinWidth(70);
        compellation.setMinWidth(70);
        
        // 确定数据导入的列
        ID.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        number.setCellValueFactory(
                new PropertyValueFactory<>("number"));
        name.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        sex.setCellValueFactory(
                new PropertyValueFactory<>("sex"));
        code.setCellValueFactory(
                new PropertyValueFactory<>("code"));
        chinese.setCellValueFactory(
                new PropertyValueFactory<>("chinese"));
        mathematics.setCellValueFactory(
                new PropertyValueFactory<>("mathematics"));
        english.setCellValueFactory(
                new PropertyValueFactory<>("english"));
        chemistry.setCellValueFactory(
                new PropertyValueFactory<>("chemistry"));
        history.setCellValueFactory(
                new PropertyValueFactory<>("history"));
        peace.setCellValueFactory(
                new PropertyValueFactory<>("peace"));
        compellation.setCellValueFactory(
                new PropertyValueFactory<>("compellation")
        );
        tv.getColumns().addAll(ID, number, name, sex, code, chinese, mathematics, english, chemistry, history, peace, compellation);
        try {
            Link.inquire2(students, xing, a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tv.getItems().addAll(students);
        bp.setCenter(tv);
    }
    
    /**
     * @param bp:
     * @param stage:
     * @Description: 新增【生物名录表】
     * @Author: 冲动火龙果
     * @Date: 2023/9/9 21:43
     * @return: void
     **/
    public static void insertFunction(BorderPane bp, Stage stage) {
        stage.setTitle("新增生物名录");
        
        //  新增【生物名录表】页面的一些 基础属性设置
        GridPane gp = new GridPane();
        gp.setStyle("-fx-font-family: 'FangSong';-fx-font-size: 15;");
        // 设置居中方式
        gp.setAlignment(Pos.CENTER);
        // 调整空隙
        gp.setHgap(10);
        gp.setVgap(10);
        
        
        //  字段列表
        Label kingdomCn = new Label("界_中文名");
        TextField kingdomCnValue = new TextField();
        // 元素，列号，行号
        gp.add(kingdomCn, 0, 1);
        gp.add(kingdomCnValue, 1, 1);
        
        Label kingdomLatin = new Label("界_拉丁名");
        TextField kingdomLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(kingdomLatin, 0, 2);
        gp.add(kingdomLatinValue, 1, 2);
        
        Label phylumCn = new Label("门_中文名");
        TextField phylumCnValue = new TextField();
        // 元素，列号，行号
        gp.add(phylumCn, 0, 3);
        gp.add(phylumCnValue, 1, 3);
        
        Label phylumLatin = new Label("门_拉丁名");
        TextField phylumLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(phylumLatin, 0, 4);
        gp.add(phylumLatinValue, 1, 4);
        
        Label classCn = new Label("纲_中文名");
        TextField classCnValue = new TextField();
        // 元素，列号，行号
        gp.add(classCn, 0, 5);
        gp.add(classCnValue, 1, 5);
        
        Label classLatin = new Label("纲_拉丁名");
        TextField classLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(classLatin, 0, 6);
        gp.add(classLatinValue, 1, 6);
        
        Label OrderCn = new Label("目_中文名");
        TextField orderCnValue = new TextField();
        // 元素，列号，行号
        gp.add(OrderCn, 0, 7);
        gp.add(orderCnValue, 1, 7);
        
        Label orderLatin = new Label("目_拉丁名");
        TextField orderLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(orderLatin, 0, 8);
        gp.add(orderLatinValue, 1, 8);
        
        Label familyCn = new Label("科_中文名");
        TextField familyCnValue = new TextField();
        // 元素，列号，行号
        gp.add(familyCn, 0, 9);
        gp.add(familyCnValue, 1, 9);
        
        Label familyLatin = new Label("科_拉丁名");
        TextField familyLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(familyLatin, 0, 10);
        gp.add(familyLatinValue, 1, 10);
        
        Label genusCn = new Label("属_中文名");
        TextField genusCnValue = new TextField();
        // 元素，列号，行号
        gp.add(genusCn, 0, 11);
        gp.add(genusCnValue, 1, 11);
        
        Label genusLatin = new Label("属_拉丁名");
        TextField genusLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(genusLatin, 0, 12);
        gp.add(genusLatinValue, 1, 12);
        
        Label speciesCn = new Label("种_中文名");
        TextField speciesCnValue = new TextField();
        // 元素，列号，行号
        gp.add(speciesCn, 0, 13);
        gp.add(speciesCnValue, 1, 13);
        
        Label speciesLatin = new Label("种_拉丁名");
        TextField speciesLatinValue = new TextField();
        // 元素，列号，行号
        gp.add(speciesLatin, 0, 14);
        gp.add(speciesLatinValue, 1, 14);
        
        Label auditor = new Label("审核人");
        TextField auditorValue = new TextField();
        // 元素，列号，行号
        gp.add(auditor, 0, 15);
        gp.add(auditorValue, 1, 15);
        
        Label directoryVersion = new Label("名录版本");
        TextField directoryVersionValue = new TextField();
        // 元素，列号，行号
        gp.add(directoryVersion, 0, 16);
        gp.add(directoryVersionValue, 1, 16);
        
        // 新增保存按钮
        Button saveButton = new Button("保存");
        gp.add(saveButton, 1, 17);
        
        // 蒙版舞台
        Stage saveBiologicalDirectoryStage = new Stage();
        saveBiologicalDirectoryStage.setTitle("新增生物名录");
        // 给保存按钮注册时间
        saveButton.setOnAction(a -> {
            try {
                // 新建生物名录对象用于保存数据
                BiologicalDirectory biologicalDirectory = new BiologicalDirectory();
                biologicalDirectory.setKingdomCn(kingdomCnValue.getText());
                biologicalDirectory.setKingdomLatin(kingdomLatinValue.getText());
                biologicalDirectory.setPhylumCn(phylumCnValue.getText());
                biologicalDirectory.setPhylumLatin(phylumLatinValue.getText());
                biologicalDirectory.setClassCn(classCnValue.getText());
                biologicalDirectory.setClassLatin(classLatinValue.getText());
                biologicalDirectory.setOrderCn(orderCnValue.getText());
                biologicalDirectory.setOrderLatin(orderLatinValue.getText());
                biologicalDirectory.setFamilyCn(familyCnValue.getText());
                biologicalDirectory.setFamilyLatin(familyLatinValue.getText());
                biologicalDirectory.setGenusCn(genusCnValue.getText());
                biologicalDirectory.setGenusLatin(genusLatinValue.getText());
                biologicalDirectory.setSpeciesCn(speciesCnValue.getText());
                biologicalDirectory.setSpeciesLatin(speciesLatinValue.getText());
                biologicalDirectory.setAuditor(auditorValue.getText());
                biologicalDirectory.setDirectoryVersion(directoryVersionValue.getText());
                
                boolean addFlag = Link.saveBiologicalDirectory(biologicalDirectory);
                String addMessage = addFlag ? "添加成功" : "添加失败";
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setHeaderText(null);
                alert.setContentText(addMessage);
                // 显示提示框
                alert.showAndWait();
                saveBiologicalDirectoryStage.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        
        //  对保存弹窗的一些属性设置
        Scene sc = new Scene(gp, 300, 650);
        // 只能操作该窗口
        saveBiologicalDirectoryStage.initOwner(stage);
        saveBiologicalDirectoryStage.initModality(Modality.WINDOW_MODAL);
        // 设置窗口不可调
        saveBiologicalDirectoryStage.setResizable(false);
        saveBiologicalDirectoryStage.setScene(sc);
        saveBiologicalDirectoryStage.show();
    }
    
    //    ----------------------------------------------------------------------
//    学生删除界面
    static void deleteFunction(BorderPane bp, Stage stage) {
//        anum++;
        GridPane gp = new GridPane();
//        设置间距
        gp.setVgap(10);
        gp.setHgap(10);
        Stage stage1 = new Stage();
        gp.setAlignment(Pos.CENTER);
//        文本
        Label l0 = new Label("ID");
        Button b1 = new Button("提交");
//        文本框
        TextField t0 = new TextField();
        
        b1.setOnAction(actionEvent -> {
            // try {
            //     if (t0.getText().trim().equals("")) {
            //         tips("删除失败", stage1);
            //     } else {
            //         if (Link.delete(Integer.valueOf(t0.getText()))) {
            //             tips("删除成功", stage1);
            //             ArrayList<Student> students = new ArrayList<>();
            //             queryFucntion(bp, students);
            //         }
            //
            //     }
            // } catch (Exception e) {
            //     e.printStackTrace();
            // }
        });

//        添加到面板中
        gp.add(l0, 0, 0);
        gp.add(t0, 1, 0);
        gp.add(b1, 2, 0);
        gp.setStyle("-fx-font-family: 'FangSong';-fx-font-size: 16;");
//        添加场景舞台
        Scene sc = new Scene(gp, 300, 260);
        
        stage1.initOwner(stage);
        stage1.initModality(Modality.WINDOW_MODAL);

//        窗口关闭时减一
        stage1.setOnCloseRequest(windowEvent -> {
//            anum--;
        });
        // 设置窗口不可调
        stage1.setResizable(false);
        stage1.setScene(sc);
        stage1.setTitle("删除界面");
        stage1.show();
    }
    
    //    -----------------------------------------------------------------------
//    学生修改界面
    public static void alterFunction(BorderPane bp, Stage stage) {
        
        GridPane gp = new GridPane();
        Stage stage1 = new Stage();
        TextField f1 = new TextField();
        Button b2 = new Button("查询");
        Label b1 = new Label("学号");
//        设置间距
        gp.setVgap(10);
        gp.setHgap(10);
        
        gp.add(b1, 0, 0);
        gp.add(f1, 1, 0);
        gp.add(b2, 1, 1);
        // 设置居中方式
        gp.setAlignment(Pos.CENTER);
        gp.setStyle("-fx-font-family: 'FangSong';-fx-font-size: 16;");
        Scene sc = new Scene(gp, 350, 220);
        stage1.initOwner(stage);
        stage1.initModality(Modality.WINDOW_MODAL);
        
        b2.setOnAction(a -> {
            if (f1.getText() == null || f1.getText().equals("")) {
                tips("请输入正确的学号", stage1);
            } else {
                try {
                    alter(bp, f1.getText(), stage);
                    stage1.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        stage1.setScene(sc);
        // 设置窗口不可调
        stage1.setResizable(false);
        stage1.setTitle("修改界面");
        stage1.show();
    }
    
    public static void alter(BorderPane bp, String id, Stage stage1) throws Exception {
        GridPane gp = new GridPane();
        Stage stage2 = new Stage();
        stage.setTitle("学校管理系统");
        // 设置居中方式
        gp.setAlignment(Pos.CENTER);
        // 调整空隙
        gp.setHgap(10);
        gp.setVgap(10);
        // 新建文本标签
        Label l1 = new Label("学号");
        // 新建文本标签：用户密码
        Label l2 = new Label("班级");
        // 新建文本标签
        Label l3 = new Label("姓名");
        // 新建文本标签：用户密码
        Label l4 = new Label("性别");
        // 新建文本标签
        Label l5 = new Label("密码");
        // 新建文本标签：用户密码
        Label l6 = new Label("语文");
        // 新建文本标签
        Label l7 = new Label("数学");
        // 新建文本标签：用户密码
        Label l8 = new Label("英语`");
        // 新建文本标签
        Label l9 = new Label("化学");
        // 新建文本标签：用户密码
        Label l10 = new Label("历史");
        // 新建输入框
        TextField f1 = new TextField();
        // 新建输入框
        TextField f2 = new TextField();
        // 新建输入框
        TextField f3 = new TextField();
        // 新建输入框
        TextField f4 = new TextField();
        // 新建输入框
        TextField f5 = new TextField();
        // 新建输入框
        TextField f6 = new TextField();
        // 新建输入框
        TextField f7 = new TextField();
        // 新建输入框
        TextField f8 = new TextField();
        // 新建输入框
        TextField f9 = new TextField();
        // 新建输入框
        TextField f10 = new TextField();
        Student student = new Student();
        // 输入原生数据
        Link.revamp1(student, id);
        Link.revamp2(student, id);
        f1.setText(student.getC0());
        f3.setText(student.getC1());
        f5.setText(student.getC2());
        f4.setText(student.getC3());
        f6.setText(Integer.toString(student.getC4()));
        f7.setText(Integer.toString(student.getC5()));
        f8.setText(Integer.toString(student.getC6()));
        f9.setText(Integer.toString(student.getC7()));
        f10.setText(Integer.toString(student.getC8()));
        f2.setText(Integer.toString(student.getC9()));
        // 学号不可更改
        f1.setEditable(false);
        gp.add(l1, 0, 0);
        gp.add(f1, 1, 0);
        gp.add(l2, 0, 1);
        gp.add(f2, 1, 1);
        gp.add(l3, 0, 2);
        gp.add(f3, 1, 2);
        gp.add(l4, 0, 3);
        gp.add(f4, 1, 3);
        gp.add(l5, 0, 4);
        gp.add(f5, 1, 4);
        gp.add(l6, 0, 5);
        gp.add(f6, 1, 5);
        gp.add(l7, 0, 6);
        gp.add(f7, 1, 6);
        gp.add(l8, 0, 7);
        gp.add(f8, 1, 7);
        gp.add(l9, 0, 8);
        gp.add(f9, 1, 8);
        gp.add(l10, 0, 9);
        gp.add(f10, 1, 9);
        Button b1 = new Button("确定");
        gp.add(b1, 1, 11);
        gp.setStyle("-fx-font-family: 'FangSong';-fx-font-size: 16;");
        ArrayList<Student> students = new ArrayList<>();
        b1.setOnAction(a -> {
            if (f4.getText().equals("男") || f4.getText().equals("女")) {
                Link.revamp3(f1.getText(), f3.getText(), f4.getText(), f5.getText());
                Link.revamp4(f1.getText(), f6.getText(), f7.getText(), f8.getText(), f9.getText(), f10.getText(), f2.getText());
//                maginit(bp,students);
                normalStage();
                tips("修改成功", stage2);
            } else {
                tips("性别不合规", stage2);
            }
            
            
        });
        Scene sc = new Scene(gp, 300, 450);
        
        stage2.initOwner(stage);
        stage2.initModality(Modality.WINDOW_MODAL);
        // 设置窗口不可调
        stage2.setResizable(false);
        stage2.setScene(sc);
        stage2.show();
    }
    
    
    //    提示框
    static void tips(String str, Stage stage) {
//        窗口数+1
        
        number++;
//        添加文本
        Label l1 = new Label(str);
        Button b1 = new Button("返回");
//        创建面板
        VBox vb = new VBox(l1, b1);
        Scene sc = new Scene(vb, 130, 130);
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        Stage stage1 = new Stage();
        stage1.setScene(sc);
//        设置窗口大小不可调节
        stage1.setResizable(false);
        stage1.setOnCloseRequest(windowEvent -> {
            number--;
        });
        b1.setOnAction(actionEvent -> {
            number--;
            stage1.close();
        });
        // 只能操作该窗口
        stage1.initOwner(stage);
        stage1.initModality(Modality.WINDOW_MODAL);
        stage1.setAlwaysOnTop(true); // 设置在窗口永远在最上层
        stage1.setTitle("提示");
        stage1.show();
    }
}