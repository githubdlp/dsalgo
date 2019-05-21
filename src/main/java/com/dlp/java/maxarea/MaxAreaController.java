package com.dlp.java.maxarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/maxarea")
public class MaxAreaController {

    @Autowired
    private MaxArea ma;

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String details() {
        StringBuilder sb = new StringBuilder("API supported : \n");
        sb.append(System.lineSeparator()).append("/<heights_separated by :>").append("\n\t: eg. /maxarea/1:2:3:4:5");
        return sb.toString();
    }

    @RequestMapping("/{heights}")
    public long getMaxArea(@PathVariable("heights") String heights) {
        return ma.findMaxArea(Arrays.stream(heights.split(":")).mapToInt(Integer::parseInt).toArray());
    }
}
