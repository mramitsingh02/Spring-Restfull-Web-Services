package com.tester.spring.rest.webservices.restfullwebservices;

import com.tester.spring.rest.webservices.pojo.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HelloWorldRestfull {
    @Autowired
    private MessageSource messageSource;


    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "Hello World!!.!.";
    }

    @GetMapping(path = "/hello-world2")
    public String helloWorld2() {
        return "Hello World !!!.";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        int messagesId = 1234;
        String messages = "Hello World.";
        return new HelloWorldBean(messagesId, messages);
    }


    @GetMapping(path = "/hello-world-bean/messages/{message}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String message) {
        int messagesId = 1234;
        return new HelloWorldBean(messagesId, message);
    }


    @GetMapping(path = "/hello-world-internationnalization")
    public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.messages", null, locale);
    }


    @GetMapping(path = "/hello-world-internationnalization2")
    public String helloWorldInternationalization() {
        return messageSource.getMessage("good.morning.messages", null, LocaleContextHolder.getLocale());
    }


}
