package com.silinx.source.swaggerranger.JavaCore.Lambdas;

import java.util.function.Function;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2019,github:Swagger-Ranger </p>
 * <p>@FileName:    Letter </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2019/12/10 1:17 </p>
 * <p>@Description:  </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class Letter {
    public static String addHeader( String text){
        return "From Raoul, Mario and Alan: " + text;
    }
    public static String addFooter( String text){
        return text + " Kind regards";
    }
    public static String checkSpelling( String text){
        return text.replaceAll("labda", "lambda");
    }

    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> transformationPipeline
            = addHeader.andThen(Letter::checkSpelling)
            .andThen(Letter::addFooter);

    public static void main( String[] args ) {
        System.out.println(addHeader("Swagger-Ranger"));

    }
}
