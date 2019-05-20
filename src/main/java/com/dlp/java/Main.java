package com.dlp.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@ComponentScan("com.dlp.java")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String process() {
        StringBuilder sb = new StringBuilder("Supported programs : \n");
        sb.append(System.lineSeparator()).append("/penaltyshoot");
        return sb.toString();
    }
}
