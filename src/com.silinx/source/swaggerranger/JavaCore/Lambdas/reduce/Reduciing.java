package com.silinx.source.swaggerranger.JavaCore.Lambdas.reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2019,github:Swagger-Ranger </p>
 * <p>@FileName:    Reduciing </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2019/12/17 0:22 </p>
 * <p>@Description:  </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class Reduciing {

    public static void main( String[] args ) {
        List<Dish> menu = new ArrayList<>();
        int totalCalories = menu.stream().collect(reducing(0,
                Dish::getCalories,
                Integer::sum));

//        Collectors

    }
}

class Dish {
    int Calories;
    String name;

    public int getCalories() {
        return Calories;
    }

    public void setCalories( int calories ) {
        Calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}