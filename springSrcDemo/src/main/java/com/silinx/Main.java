package com.silinx;

import com.silinx.app.App;
import com.silinx.beanPostProcessorDemo.Index;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        /**
         * spring-context 依赖了spring的这个jar包，
         * 就可以使用AnnotationConfigApplicationContext并传入配置类就能启动spring，使用其ioc和aop
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
//        applicationContext.getBean(IndexService.class).index();
        // 單獨使用自定義的注解來獲取定義的bean，因爲jdk是接口代理，所以要用接口來獲取
        Index index = applicationContext.getBean(Index.class);

    }
}
