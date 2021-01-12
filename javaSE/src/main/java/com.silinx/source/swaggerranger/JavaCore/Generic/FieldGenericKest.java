package com.silinx.source.swaggerranger.JavaCore.Generic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description
 * @since 2020/5/11 15:00
 */

public class FieldGenericKest {

    public Map<String,Integer> map = new HashMap<>();
    public List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        FieldGenericKest kest = new FieldGenericKest();

        Field map = kest.getClass().getField("map");
        Field list = kest.getClass().getField("list");

        System.out.println("=====map=====");
        System.out.println("map.getType=" + map.getType());
        System.out.println("map.getGenericType=" + map.getGenericType());

        System.out.println("=====list=====");
        System.out.println("list.getType=" + list.getType());
        System.out.println("list.getGenericType=" + list.getGenericType());

        /**
         * java虽然运行时会有类型擦除，但是会保留Field的泛型信息，可以通过Field.getGenericType() 取字段的泛型
         * 但是注意，这里不能获取到字段的真实类型HashMap和ArrayList。
         * 真实的类型当然不能用Field来获取，需要用对应的Value来获取
         */
        Object mapVal = map.get(kest);
        if(mapVal != null){
            Class<?> clz = mapVal.getClass();
            System.out.println(mapVal.getClass().getName());
        }
    }
}
