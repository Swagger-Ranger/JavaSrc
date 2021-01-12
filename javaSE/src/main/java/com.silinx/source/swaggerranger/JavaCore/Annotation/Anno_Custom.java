package com.silinx.source.swaggerranger.JavaCore.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 定义注解
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface Anno_Custom {

    /**
     * 如果注解中只有一个属性那么默认定义为String value()
     * 同时在使用自定义注解时就能直接为@Anno_Custom("Swagger-Ranger")来简写(value="Swagger-Ranger")
     * @return
     */
    String value() default "";
    /**
     * 定义注解中还可以定义参数值即在注解中设置方法，因为每个注解自动继承了java.lang.annotation.Annotation接口，
     * 而在注解中定义方法实际上就是在为注解设置配置参数，这样在使用自定义注解时就必须向注解中传入参数值，
     * 或者在自定义方法中中设置default值就可以在使用自定义注解时不传入而使用默认值
     * @return
     */
    String name() default "Swagger-Ranger";

    /**
     * 注解元素必须要有值，我们在定义注解时，常常使用空字符串，0作为默认值
     * 也经常使用复数（比如-1）来表示不存在的含义
     * @return
     */
    int age() default 18;

    /**
     * 也可以设置数组
     * @return
     */
    String[] schools() default {"南开大学","西南联大"};

}
