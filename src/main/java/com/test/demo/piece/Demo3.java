//package com.test.demo.calculate;
//
///**
// * @author naison
// * @since 3/8/2020 16:56
// */
//
//import org.springframework.beans.factory.ListableBeanFactory;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
///**
// * Configuration equivalent to {@code @EnableWebMvc}.
// */
//@Configuration
//public static class EnableWebMvcConfiguration extends DelegatingWebMvcConfiguration {
//    @Bean
//    @Primary
//    @Override
//    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
//        // Must be @Primary for MvcUriComponentsBuilder to work
//        return super.requestMappingHandlerMapping();
//    }
//}
