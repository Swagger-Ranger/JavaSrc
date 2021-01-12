package com.silinx.source.swaggerranger.JavaCore.Enum;

import java.util.Arrays;

/**
 * 自定义枚举类的属性和构造函数
 */
public enum Enum_Advance_Custom {

    //枚举的内容必须首先写在前面,不然编译器报错，因为调用构造函数创建枚举实例只能由编译器执行，无法手动调用
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");    //，逗号分隔，分号结尾

    //定义类变量desc：描述
    private String desc;

    //自定义构造方法
    Enum_Advance_Custom( String desc ) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    //Enum的toString()可以重新但也只有toString()能够重写
    @Override
    public String toString() {
//        return super.toString();
        return desc;
    }

    public static void main( String[] args ) {
        for (Enum_Advance_Custom e : Enum_Advance_Custom.values()) {
            System.out.println(e.name() + "----" + e.getDesc());
        }

        Class c = Enum_Advance_Custom.FRIDAY.getDeclaringClass();
        for (Object enumConstant : c.getEnumConstants()) {
            System.out.println("getEnumConstants():" + enumConstant);
        }
        System.out.println("getEnumConstants():" + Arrays.toString(c.getEnumConstants()));
    }

}
