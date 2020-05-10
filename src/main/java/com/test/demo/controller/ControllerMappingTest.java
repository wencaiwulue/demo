package com.test.demo.controller;

import com.test.demo.config.RequestMappingTest;
import com.test.demo.model.A;
import com.test.demo.model.B;
import com.test.demo.model.CResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author naison
 * @since 3/6/2020 18:57
 */
@Controller
@RequestMappingTest("/1")
@RequestMapping("/2")
public class ControllerMappingTest {

    @RequestMappingTest("/test1")
    @ResponseBody
    public Object test1(@ModelAttribute A a, @ModelAttribute B b) {
        System.out.println(a.getId());
        System.out.println(b.getId());
        return CResponse.of(true);
    }

    @RequestMappingTest("/test2")
    public Object test2(@ModelAttribute A a, @ModelAttribute B b) {
        System.out.println(a.getId());
        System.out.println(b.getId());
        return true;
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test(@ModelAttribute A a, @ModelAttribute B b) {
        System.out.println(a.getId());
        System.out.println(b.getId());
        return CResponse.of(true);
    }
}
