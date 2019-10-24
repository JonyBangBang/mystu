package com.gn.stu.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/12 15:23
 */
//@Component
public class MyApplicationContext implements ApplicationContextAware,BeanPostProcessor,EnvironmentAware {

    private static int count=0;
    private static ApplicationContext app;
    private static Environment env;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyApplicationContext...");
        app = applicationContext;
    }
    public static Object getbean(String  beanName){
        System.out.println(app.getBeanDefinitionCount());
        return app.getBean(beanName);
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        count++;
        System.out.println(bean.getClass().getName()+".beanName:"+beanName+"&&postProcessBeforeInitialization..."+count);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        count++;
        System.out.println(bean.getClass().getName()+".beanName:"+beanName+"&&postProcessAfterInitialization..."+count);
        return bean;
    }

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }
}
