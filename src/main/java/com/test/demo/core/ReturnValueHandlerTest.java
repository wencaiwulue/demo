package com.test.demo.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.model.CResponse;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;

/**
 * @author naison
 * @since 3/3/2020 15:00
 */
public class ReturnValueHandlerTest implements HandlerMethodReturnValueHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        CmdPathTest annotation = returnType.getAnnotatedElement().getDeclaredAnnotation(CmdPathTest.class);
        return annotation != null;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);// 这一步标识这个request已经被处理过了，不然会重复处理。这个很重要的

        Object result = returnValue;
        if (!(returnValue instanceof CResponse)) {// 这里判断一下回包是不是通用的格式，如果不是，需要封装
            result = new CResponse<>(returnValue);
        }

        HttpServletResponse nativeResponse = webRequest.getNativeResponse(HttpServletResponse.class);
        assert nativeResponse != null;
        byte[] bytes = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(result);

        nativeResponse.resetBuffer();
        nativeResponse.getOutputStream().write(bytes);
        nativeResponse.getOutputStream().flush();
    }
}
