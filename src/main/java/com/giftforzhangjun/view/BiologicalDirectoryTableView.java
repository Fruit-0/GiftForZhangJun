package com.giftforzhangjun.view;

import com.giftforzhangjun.tableModel.BiologicalDirectory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName BiologicalDirectoryView.java
 * @Description BiologicalDirectory 的自定义页面模型对象
 * @createTime 2023年09月11日 00:23:00
 */
public class BiologicalDirectoryTableView {
    //  定义表格对象
    TableView<BiologicalDirectory> tv = new TableView();
    public BiologicalDirectoryTableView() {
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
    }
    
    public TableView<BiologicalDirectory> getTv() {
        return tv;
    }
}
