package de.segoy.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    @RequestMapping("/owners")
    public String listOwners(){
        return "owners/index";
    }
}