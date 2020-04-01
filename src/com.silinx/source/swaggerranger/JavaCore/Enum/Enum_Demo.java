package com.silinx.source.swaggerranger.JavaCore.Enum;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: Enum_Demo
 * @Author: liufei32@outlook.com
 * @Date: 2019/4/5 21:05
 * @Description:
 * @Aha-eureka:
 *******************************************************************************/

public class Enum_Demo {

    public static void main( String[] args ) {
        Day day = Day.FRIDAY;
        System.out.println(day);

        System.out.println(day.getDeclaringClass());
        System.out.println(Enum.valueOf(Day.class, "SUNDAY"));
        System.out.println(Day.valueOf("SUNDAY"));
        System.out.println(Day.FRIDAY.name());

        for (Day d:Day.values()) System.out.println(d.name());


    }

}

enum Day {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,SATURDAY, SUNDAY,FRIDAY
}