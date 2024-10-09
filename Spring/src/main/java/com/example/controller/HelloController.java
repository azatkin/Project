package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        // Логируем входящий запрос
        logger.info("Received request to greet: {}", name);

        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message", "Hello, " + name + "!");

        // Логируем сообщение, которое будет отправлено во View
        logger.info("Responding with message: Hello, {}", name);

        return modelAndView;
    }
}
