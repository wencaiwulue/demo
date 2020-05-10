package com.test.demo.config;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;

/**
 * @author naison
 * @since 3/6/2020 17:22
 */
public class HandlerMappingHandlerTest extends AbstractHandlerMethodMapping<RequestMappingInfo> {

    @Override
    protected boolean isHandler(Class beanType) {
        return beanType.getDeclaredAnnotation(RestController.class) != null || beanType.getDeclaredAnnotation(Controller.class) != null;
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo info = createRequestMappingInfo(method);
        if (info != null) {
            RequestMappingInfo typeInfo = createRequestMappingInfo(handlerType);
            if (typeInfo != null) {
                info = typeInfo.combine(info);
            }
        }
        return info;
    }

    @Override
    protected Set<String> getMappingPathPatterns(RequestMappingInfo mapping) {
        return mapping.getPatternsCondition().getPatterns();
    }

    @Override
    protected RequestMappingInfo getMatchingMapping(RequestMappingInfo mapping, HttpServletRequest request) {
        Set<String> patterns = mapping.getPatternsCondition().getPatterns();
        for (String pattern : patterns) {
            if (pattern.equals(request.getServletPath())) {
                return mapping;
            }
        }
        return null;
    }

    @Override
    protected Comparator<RequestMappingInfo> getMappingComparator(HttpServletRequest request) {
        return (info1, info2) -> info1.compareTo(info2, request);
    }

    private RequestMappingInfo createRequestMappingInfo(AnnotatedElement element) {
        RequestMappingTest annotation = AnnotatedElementUtils.findMergedAnnotation(element, RequestMappingTest.class);
        if (annotation == null) return null;

        RequestMappingInfo.Builder builder = RequestMappingInfo
                .paths(annotation.value());
        return builder.build();
    }

    @Override
    public void afterPropertiesSet() {
        super.setOrder(-1);
        super.afterPropertiesSet();
    }
}
