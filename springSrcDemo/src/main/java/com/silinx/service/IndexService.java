package com.silinx.service;

import com.silinx.beanPostProcessorDemo.Index;
import org.springframework.stereotype.Component;

/**
 * 前面可以不繼承接口也能getbean獲取到，是因爲spring也是用cglib來使用子類來獲取，這裏自定義了一個bean處理類所以要實現接口
 */
@Component
public class IndexService implements Index {

    public void index() {
        System.out.println("hello spring");
    }
}
