package com.ouimeet.laravel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/layout")
public class LayoutController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/top")
    public String top() {
        return "top";
    }

    @RequestMapping(value = "/left")
    public String left() {
        return "left";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
