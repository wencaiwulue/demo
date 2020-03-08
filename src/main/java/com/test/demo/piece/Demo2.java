//package com.test.demo.calculate;
//
//import org.springframework.web.servlet.HandlerAdapter;
//import org.springframework.web.servlet.HandlerExecutionChain;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author naison
// * @since 3/7/2020 22:48
// */
//public class Demo2 {
//    // 这里是DispatchServlet的最主要的方法，没有之一
//    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        // Determine handler for the current request.
//        HandlerExecutionChain mappedHandler = getHandler(processedRequest);// 这里会便利所有的HandlerMapping(我们自定义的HandlerMappingHandlerTest就会出现在这里，成为规则), 然后构建执行链
//
//        // Determine handler adapter for the current request.
//        HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());// 这里也可以自定义，默认是RequestMappingHandlerAdapter
//
//        // Actually invoke the handler.
//        ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
//    }
//}