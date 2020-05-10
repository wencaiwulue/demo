package com.test.demo.config;

import com.test.demo.interceptor.InterceptorTest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author naison
 * @since 3/3/2020 14:37
 */
@Configuration
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HandlerMapping handlerMappingTest() {
        HandlerMethodMappingTest handlerTest = new HandlerMethodMappingTest();
        handlerTest.setInterceptors(new InterceptorTest());//注册到自定义的路由注解中
        return handlerTest;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorTest());// 注册到spring默认的路由注解
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(new ReturnValueHandlerTest());
    }
}
