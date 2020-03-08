//package com.test.demo.calculate;
//
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.web.method.annotation.MapMethodProcessor;
//import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
//import org.springframework.web.method.annotation.ModelMethodProcessor;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
//import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
//import org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter;
//import org.springframework.web.servlet.mvc.method.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author naison
// * @since 3/8/2020 18:13
// */
//public class RequestMappingHandlerAdapter extends AbstractHandlerMethodAdapter
//        implements BeanFactoryAware, InitializingBean {
//
//    @Override
//    public void afterPropertiesSet() {
//        // Do this first, it may add ResponseBody advice beans
//        initControllerAdviceCache();
//        if (this.argumentResolvers == null) {
//            List<HandlerMethodArgumentResolver> resolvers = getDefaultArgumentResolvers();
//            this.argumentResolvers = new HandlerMethodArgumentResolverComposite().addResolvers(resolvers);
//        }
//        if (this.initBinderArgumentResolvers == null) {
//            List<HandlerMethodArgumentResolver> resolvers = getDefaultInitBinderArgumentResolvers();
//            this.initBinderArgumentResolvers = new HandlerMethodArgumentResolverComposite().addResolvers(resolvers);
//        }
//        if (this.returnValueHandlers == null) {
//            List<HandlerMethodReturnValueHandler> handlers = getDefaultReturnValueHandlers();// !!!这里调用下面的代码!!!
//            this.returnValueHandlers = new HandlerMethodReturnValueHandlerComposite().addHandlers(handlers);
//        }
//
//        // 省略代码
//
//        {
//            protected List<HandlerMethodReturnValueHandler> getDefaultReturnValueHandlers() {//!!!调用这里!!!
//                List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>();
//
//                // Single-purpose return value types
//                handlers.add(new ModelAndViewMethodReturnValueHandler());
//                handlers.add(new ModelMethodProcessor());
//                handlers.add(new ViewMethodReturnValueHandler());
//                handlers.add(new HttpEntityMethodProcessor(
//                        getMessageConverters(), this.contentNegotiationManager, this.responseBodyAdvice));
//
//                // Annotation-based return value types
//                handlers.add(new ModelAttributeMethodProcessor(false));
//                handlers.add(new RequestResponseBodyMethodProcessor(//这里的优先级很高，自定义的会放在这个list的尾巴上。导致没法儿执行
//                        getMessageConverters(), this.contentNegotiationManager, this.responseBodyAdvice));
//
//                // Multi-purpose return value types
//                handlers.add(new ViewNameMethodReturnValueHandler());
//                handlers.add(new MapMethodProcessor());
//
//                // Custom return value types
//                if (getCustomReturnValueHandlers() != null) {
//                    handlers.addAll(getCustomReturnValueHandlers());
//                }
//
//                // Catch-all
//                handlers.add(new ModelAttributeMethodProcessor(true));
//
//                return handlers;
//            }
//        }
//    }
//}