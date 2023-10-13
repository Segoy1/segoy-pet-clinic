package de.segoy.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping({"/owners/find", "/oups"})
    public String oupsHandler(){
        return "notimplemented";
    }
}
