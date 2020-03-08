package com.test.demo.controller;

import com.test.demo.config.RequestMappingTest;
import com.test.demo.model.A;
import com.test.demo.model.B;
import com.test.demo.model.CResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author naison
 * @since 3/6/2020 18:57
 */
@RestController
@RequestMappingTest("/1")
public class ControllerMappingTest {

    @RequestMappingTest("/test1")
    public Object test1(@ModelAttribute A a, @ModelAttribute B b) {
        System.out.println(a.getId());
        System.out.println(b.getId());
        return CResponse.of(true);
    }
}
