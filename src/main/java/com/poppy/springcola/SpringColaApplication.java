package com.poppy.springcola;

import com.alibaba.cola.boot.EventRegister;
import com.alibaba.cola.boot.ExtensionRegister;
import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import com.alibaba.cola.extension.Extension;
import com.alibaba.cola.extension.ExtensionPointI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alibaba.cola","com.poppy.springcola"})
public class SpringColaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringColaApplication.class, args);

        /**
         * 初始化cola扩展点的上下文
         * @see com.alibaba.cola.boot.SpringBootstrap
         */
        ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
        ExtensionRegister extensionRegister = applicationContext.getBean(ExtensionRegister.class);
        EventRegister eventRegister = applicationContext.getBean(EventRegister.class);

        Map<String, Object> extensionBeans = applicationContext.getBeansWithAnnotation(Extension.class);
        extensionBeans.values().forEach(
                extension -> extensionRegister.doRegistration((ExtensionPointI) extension)
        );

        Map<String, Object> eventHandlerBeans = applicationContext.getBeansWithAnnotation(EventHandler.class);
        eventHandlerBeans.values().forEach(
                eventHandler -> eventRegister.doRegistration((EventHandlerI) eventHandler)
        );

    }

}
