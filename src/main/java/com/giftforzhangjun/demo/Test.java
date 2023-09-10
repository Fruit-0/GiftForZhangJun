package com.giftforzhangjun.demo;

/**
 * @author 冲动火龙果
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2023年09月11日 01:12:00
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个示例对象
        String str = "Hello, World!";
        
        // 使用反射获取类名
        Class<?> clazz = str.getClass();
        String className = clazz.getSimpleName();
        
        System.out.println("类名：" + className);
    }
    
}
