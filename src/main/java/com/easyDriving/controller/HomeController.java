package com.easyDriving.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hexing on 15-12-23.
 */
@Controller
public class HomeController {
    @RequestMapping("")
    public String getRegister(){
        return "index";
    }
}
