package com.test.demo.config;

import com.test.demo.filter.InterceptorTest;
import com.test.demo.filter.ReturnValueHandlerTest;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author naison
 * @since 3/3/2020 14:37
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HandlerMapping handlerMappingTest() {
        HandlerMappingHandlerTest handlerTest = new HandlerMappingHandlerTest();
        handlerTest.setInterceptors(new InterceptorTest());
        return handlerTest;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorTest());
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(0, new ReturnValueHandlerTest());
    }
}
