package com.test.demo.controller;

import com.test.demo.model.A;
import com.test.demo.model.B;
import com.test.demo.model.CResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author naison
 * @since 3/1/2020 11:06
 */
@Controller
@RequestMapping("/")
public class ControllerTest {

    @PostMapping("/test")
    @ResponseBody
    public Object test(@ModelAttribute A a, @ModelAttribute B b) {
        System.out.println(a.getId());
        System.out.println(b.getId());
        return CResponse.of(true);
    }


}
