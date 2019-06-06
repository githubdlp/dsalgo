package com.dlp.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String process() {
        StringBuilder sb = new StringBuilder("Supported programs : \n");
        sb.append(System.lineSeparator()).append("/penaltyshoot\n\t").append(": Penalty goal shoot out decider.");
        sb.append(System.lineSeparator()).append("/maxarea\n\t").append(": Maximum rectangular area formed by consecutive buildings.");
        sb.append(System.lineSeparator()).append("/nstep\n\t").append(": No of combination of 1 and 2 steps to cover N steps.");
        return sb.toString();
    }
}
