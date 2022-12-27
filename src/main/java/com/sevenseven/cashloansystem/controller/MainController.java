package com.sevenseven.cashloansystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping
    public String start() {
        return "redirect:/login";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/access-denied")
    public String access() {
        return "access-denied";
    }

}
