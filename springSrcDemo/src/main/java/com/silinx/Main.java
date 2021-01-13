package com.silinx;

import com.silinx.app.App;
import com.silinx.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        /**
         * spring-context 依赖了spring的这个jar包，
         * 就可以使用AnnotationConfigApplicationContext并传入配置类就能启动spring，使用其ioc和aop
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        applicationContext.getBean(IndexService.class).index();

    }
}
