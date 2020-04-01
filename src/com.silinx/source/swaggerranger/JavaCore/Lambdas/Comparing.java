package com.silinx.source.swaggerranger.JavaCore.Lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2019,github:Swagger-Ranger </p>
 * <p>@FileName:    Comparing </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2019/12/12 9:14 </p>
 * <p>@Description: 使用comparing方法来提取一个comparator传递给lambda表达式 </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class Comparing {

    public static void main( String[] args ) {
        List<Apple> apples = Arrays.asList(
                new Apple(1, Apple.Color.RED, Apple.TYPE.FUJI),
                new Apple(2, Apple.Color.BLUE, Apple.TYPE.FUJI),
                new Apple(3, Apple.Color.OTHER, Apple.TYPE.OTHER)
        );

        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        apples.forEach(x -> System.out.println(x.getColor()));
    }




}

class Apple {
    private float weight;
    private Color color;
    private TYPE type;

    public Apple( float weight, Color color, TYPE type ) {
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public enum Color {RED, BLUE, GREEN, OTHER,}

    public enum TYPE {MACTONISH, FUJI, YANYUAN, OTHER,}


    public float getWeight() {
        return weight;
    }

    public void setWeight( float weight ) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor( Color color ) {
        this.color = color;
    }

    public TYPE getType() {
        return type;
    }

    public void setType( TYPE type ) {
        this.type = type;
    }
}