package com.silinx.source.swaggerranger.JavaCore.Lambdas.Stream;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/*******************************************************************************
 * <p>@Copyright (C), 2018-2019,github:Swagger-Ranger </p>
 * <p>@FileName:    FabLambda </p>
 * <p>@Author:      liufei32@outlook.com </p>
 * <p>@Date:        2019/12/16 0:11 </p>
 * <p>@Description:  </p>
 * <p>@Aha-eureka: </p>
 * 创建了一个IntSupplier的实例。此对象有可变的状态：它在两个实例变量中
 * 记录了前一个斐波纳契项和当前的斐波纳契项。getAsInt在调用时会改变对象的状态，由此在
 * 每次调用时产生新的值。相比之下，使用iterate的方法则是纯粹不变的：它没有修改现有状态，
 * 但在每次迭代时会创建新的元组。你将在第7章了解到，你应该始终采用不变的方法，以便并行
 * 处理流，并保持结果正确。
 ******************************************************************************/

public class FabLambda {


    public static void main( String[] args ) {
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach( System.out::println);
    }
}
