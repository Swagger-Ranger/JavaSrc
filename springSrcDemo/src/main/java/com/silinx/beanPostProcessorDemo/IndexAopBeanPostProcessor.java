package com.silinx.beanPostProcessorDemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class IndexAopBeanPostProcessor implements BeanPostProcessor {


    /**
     * 自定義一個bean的注入動作，也可以是postProcessBeforeInitialization;
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object o = null;
        if (beanName.equals("indexService")) {
            Class<?>[] interfaces = bean.getClass().getInterfaces();
            // 使用jdk動態代理
            o = Proxy.newProxyInstance(IndexAopBeanPostProcessor.class.getClassLoader(), interfaces, new IndexProxyHandler(bean));

        }
        return o;
    }

}
