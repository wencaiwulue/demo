package com.test.demo.config;

import com.test.demo.filter.InterceptorTest;
import com.test.demo.filter.ReturnValueHandlerTest;
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
        handlers.add(new ReturnValueHandlerTest());
    }
}
