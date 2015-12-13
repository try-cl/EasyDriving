package com.easyDriving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hexing on 15-12-11.
 */
@Controller
public class HelloController {
    @RequestMapping("")
    public String getHello(){

        return "hello";
    }
}