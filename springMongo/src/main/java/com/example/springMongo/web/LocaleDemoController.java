package com.example.springMongo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

@RestController

public class LocaleDemoController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greeting")
    public String getGreetingMessage(WebRequest request) {
        // Retrieve current locale from the request
        Locale locale = request.getLocale();

        // Fetch the translated greeting message using the MessageSource
        String greetingMessage = messageSource.getMessage("greeting", null, locale);

        return greetingMessage;
    }
}
