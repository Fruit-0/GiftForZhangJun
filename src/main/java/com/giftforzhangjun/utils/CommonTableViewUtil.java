package com.giftforzhangjun.utils;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName CommonTableViewUtils.java
 * @Description 除了 <T>，你还可以使用其他字母或单词来表示泛型类型参数，例如：
 * <T> 作为类型参数的标志，
 * <E>：表示 "Element"，通常用于集合类，表示集合中的元素类型。
 * <K>：表示 "Key"，通常用于表示映射（Map）中的键的类型。
 * <V>：表示 "Value"，通常用于表示映射（Map）中的值的类型。
 * <S>：表示 "Source"，通常用于表示源类型。
 * <D>：表示 "Destination"，通常用于表示目标类型。
 * @createTime 2023年09月11日 00:28:00
 */
public class CommonTableViewUtil {
    
    // 声明一个私有静态成员变量，用于保存单例实例
    private static CommonTableViewUtil instance;
    
    // 声明私有构造方法，防止外部直接实例化
    private CommonTableViewUtil() {
        // 进行初始化操作
    }
    
    // 提供一个公共的静态方法，用于获取单例实例
    public static synchronized CommonTableViewUtil getInstance() {
        if (instance == null) {
            synchronized (CommonTableViewUtil.class) {
                if (instance == null) {
                    instance = new CommonTableViewUtil();
                }
            }
        }
        return instance;
    }
    
    /**
     * @param t:
     * @Description: 手动创建对象
     * @Author: 冲动火龙果
     * @Date: 2023/9/11 0:45
     * @return: javafx.scene.control.TableView<T>
     **/
    public <T> TableView<T> getTableView(T t) {
        TableView<T> tv = new TableView();
        
        // 使用反射获取对象的类
        Class<?> clazz = t.getClass();
        // 获取对象的所有字段
        Field[] fields = clazz.getDeclaredFields();
        // 遍历字段
        for (Field field : fields) {
            // 获取字段名称
            String fieldName = field.getName();
            System.out.println("Field Name: " + fieldName);
            
            // 创建列对象并指定列名  默认列名为属性名
            TableColumn tableColumnSub = new TableColumn(fieldName);
            tableColumnSub.setMinWidth(50);
            // 指定列对象的取值逻辑为 TableView 对象中填充的对象的何种属性的值，即 fieldName = 对象属性名
            tableColumnSub.setCellValueFactory(new PropertyValueFactory<>(fieldName));
            tableColumnSub.setStyle("-fx-alignment: CENTER;");
            // 将列填充到表模型中
            tv.getColumns().addAll(tableColumnSub);
        }
        
        return tv;
    }
    
    /**
     * @param T: 自动创建表对象
     * @Description:
     * @Author: 冲动火龙果
     * @Date: 2023/9/11 1:17
     * @return: javafx.scene.control.TableView<T>
     **/
    public <T> TableView<T> autoGetTableView(T t) {
        TableView<T> tv = new TableView();
        Class<?> clazz = t.getClass();
        // 获取简写的类名（不包含路径）
        String className = clazz.getSimpleName();
        // 类名驼峰转换为表名
        String tableName = CommonTableSql.convertCamelToSnake(className);
        // 获取对象的所有字段
        Field[] fields = clazz.getDeclaredFields();
        // 遍历字段
        for (Field field : fields) {
            // 获取字段名称
            String fieldName = field.getName();
            
            // 字段名驼峰转换
            String column = CommonTableSql.convertCamelToSnake(fieldName);
            // 创建列对象并指定列名  直接去数据库查询表的中文注释，作为列名
            String fieldNameComment = CommonTableSql.getTableColumnComment(tableName, column);
            
            // 创建列对象
            TableColumn tableColumnSub = new TableColumn(fieldNameComment);
            tableColumnSub.setMinWidth(50);
            // 指定列对象的取值逻辑为 TableView 对象中填充的对象的何种属性的值，即 fieldName = 对象属性名
            tableColumnSub.setCellValueFactory(new PropertyValueFactory<>(fieldName));
            // 设置样式
            tableColumnSub.setStyle("-fx-alignment: CENTER;");
            // 将列填充到表模型中
            tv.getColumns().addAll(tableColumnSub);
        }
        return tv;
    }
    
    /**
     * @Description: 直接通过list创建完整的表数据  基础的页面布局为上、中、下三层，上层为vbox，vbox的最后一层为
     * 增删改查的功能按钮；中层为数据列表，下层为分页
     * @Author: 冲动火龙果
     * @Date: 2023/9/11 1:49
     * @param objectList:
     * @return: javafx.scene.control.TableView<T>
     **/
    public <T> TableView<T> getcCompleteTableView(List<T> objectList) {
        TableView<T> tv = null;
        if (!objectList.isEmpty()) {
            T t = objectList.get(0);
            // 创建表模型
            tv = autoGetTableView(t);
            // 清空表模型的数据
            tv.getItems().removeAll();
            // 重新灌数
            tv.getItems().addAll(objectList);
            // 刷新
            tv.refresh();
        }
        return tv;
    }
}