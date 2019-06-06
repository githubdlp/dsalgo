package com.dlp.java.NStep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NStepController {

    @Autowired
    private NStep nStep;

    @RequestMapping("/nstep/{steps}")
    public List<String> getCombinations(@PathVariable("steps") int steps) {
        return nStep.findCombination(steps);
    }
}
