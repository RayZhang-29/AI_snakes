package com.AI_snakes.backend.controller.bot.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String index() {
        return "pk/index.html";
    }
}
