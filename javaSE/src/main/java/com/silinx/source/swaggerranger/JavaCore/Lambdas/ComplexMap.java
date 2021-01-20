package com.silinx.source.swaggerranger.JavaCore.Lambdas;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2019,github:Swagger-Ranger </p>
 * <p>@FileName:    ComplexMap </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2019/12/13 0:42 </p>
 * <p>@Description: 更加复杂的lambda map和flatMap的操作 </p>
 * <p>@Aha-eureka: </p>
 ******************************************************************************/

public class ComplexMap {

    //流里面可以嵌套流
    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);
    List<int[]> pairs = numbers1
            .stream()
            .flatMap(i -> numbers2.stream()
                    .map(j -> new int[]{i, j}))
            .collect(toList());
}
