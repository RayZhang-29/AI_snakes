package com.AI_snakes.backend.controller.bot.pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pk/")
public class BotInfoController {

    @RequestMapping("getbotinfo/")
    public Map<String, String> getBotInfo() {
        Map<String, String> bot1 = new HashMap<>();
        bot1.put("name", "tiger");
        bot1.put("rating", "1500");

//        Map<String, String> bot2 = new HashMap<>();
//        bot2.put("name", "apple");
//        bot2.put("rating", "1800");
//
//        List<Map<String, String>> list = new LinkedList<>();
//        list.add(bot1);
//        list.add(bot2);
        return bot1;
    }
}
