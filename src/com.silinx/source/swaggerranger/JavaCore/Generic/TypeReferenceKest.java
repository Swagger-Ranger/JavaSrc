package com.silinx.source.swaggerranger.JavaCore.Generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/5/9 15:15
 */

public class TypeReferenceKest {

    public static void main(String[] args) {
        IntMap intMap = new IntMap();

        System.out.println(intMap.getClass().getSuperclass());

        Type type = intMap.getClass().getGenericSuperclass();
        if(type instanceof ParameterizedType){
            ParameterizedType p = (ParameterizedType) type;
            for (Type t : p.getActualTypeArguments()){
                System.out.println(t);
            }
        }

        System.out.println("=====newclass=====");
        HashMap<String,Integer> newIntMap = new HashMap<>();

        System.out.println(newIntMap.getClass().getSuperclass());

        Type newClassType = newIntMap.getClass().getGenericSuperclass();
        if(newClassType instanceof ParameterizedType){
            ParameterizedType p = (ParameterizedType) newClassType;
            for (Type t : p.getActualTypeArguments()){
                System.out.println(t);
            }
        }

        System.out.println("=====subclass=====");
        /**
         * 匿名类可以使你代码更简洁，它们使你能够同时声明和实例化一个类匿名类将会生成自己的类文件，它们就像局部类，除了它们没有名称，如果你只需要使用局部类一次，请使用它们
         * 这里能取到实际的类型，是因为其创建了一个明确类型的匿名类
         */
        HashMap<String,Integer> subIntMap = new HashMap<String,Integer>(){
//            private int i = 1;
//            public int getI() {
//                return i;
//            }
//
//            @Override
//            public String toString() {
//                return "ssssssssssssss";
//            }
        };

        System.out.println(subIntMap);
        System.out.println(subIntMap.getClass().getSuperclass());

        Type subClassType = subIntMap.getClass().getGenericSuperclass();
        if(subClassType instanceof ParameterizedType){
            ParameterizedType p = (ParameterizedType) subClassType;
            for (Type t : p.getActualTypeArguments()){
                System.out.println(t);
            }
        }
    }


    public static class IntMap extends HashMap<String,Integer> {
    }

}
