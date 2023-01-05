package com.silinx.source.swaggerranger.JavaCore.Generic;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Email:liufei32@outlook.com  github:Swagger-Ranger
 * @description 泛型测试 https://yq.aliyun.com/articles/609441
 * @since 2020/5/9 14:47
 */

public class GenericTest {


    public static void main( String[] args ) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");

        JSONObject o = new JSONObject();
        o.put("k",list);

        List<String> types = o.getObject("k",List.class);
        System.out.println(JSON.toJSONString(types));

        /**
         * 在fastJson或者fastxml中通过反序列化获取成对象时：
         *     需要使用TypeReference来明确指定要转成的对象引用类型，不然直接转可能会失败，
         *     因为如同TypeReferenceKest类中newclass中的操作，new出来的对象是拿不到字类的对象的，
         * 而new TypeReference<List<String>>(){}创建了一个继承TypeReference>的匿名子类，
         * 在其构造函数中拿到了泛型对应Type(java.lang.reflect.ParameterizedType)
         *
         */
        List<String> types2 = o.getObject("k",new TypeReference<List<String>>(){});
        System.out.println(JSON.toJSONString(types2));
    }
}
