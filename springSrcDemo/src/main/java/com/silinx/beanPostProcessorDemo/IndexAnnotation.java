package com.silinx.beanPostProcessorDemo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import({IndexAopBeanPostProcessor.class})
public @interface IndexAnnotation {

}
