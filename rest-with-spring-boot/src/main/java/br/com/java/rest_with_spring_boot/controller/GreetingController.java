package br.com.java.rest_with_spring_boot.controller;

import br.com.java.rest_with_spring_boot.model.GreetingModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public GreetingModel greetingModel(
            @RequestParam(value = "name", defaultValue = "Word")
            String name){
        return new GreetingModel(counter.incrementAndGet(), String.format(template,name));
    }
}