package com.dlp.java.NStep;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class NStep {

    public List<String> findCombination(int steps) {
        List<String> response = new LinkedList<>();
        if (steps < 1 || steps > 100) {
            response.add("Enter steps between 1 - 100");
        } else {
            recursiveGetCombination(response, steps, "");
        }
        return response;
    }

    private void recursiveGetCombination(List<String> response, int steps, String s) {
        if (steps < 1) {
            response.add(s);
            return;
        }
        if (steps == 1) {
            response.add(s + "1");
        } else {
            recursiveGetCombination(response, steps - 1, s + "1");
            recursiveGetCombination(response, steps - 2, s + "2");
        }
    }
}
