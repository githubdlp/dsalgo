package com.dlp.java.penaltyshoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/penaltyshoot")
public class PenaltyShootController {

    @Autowired
    private PenaltyShootOut pso;

    @RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String details() {
        StringBuilder sb = new StringBuilder("API supported : \n");
        sb.append(System.lineSeparator()).append("/record/<TeamName A/B>/<isGoal>").append("\n\t: eg. /record/A/true , /record/B/false");
        sb.append(System.lineSeparator()).append("/winner \n\t: Shows the winner if game can be concluded");
        sb.append(System.lineSeparator()).append("/reset/<rounds> \n\t: reset the score for given rounds");
        sb.append(System.lineSeparator()).append("/reset \n\t: Reset the score for 5 rounds");
        return sb.toString();
    }

    @RequestMapping(value = "/record/{team}/{isGoal}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String recordScore(@PathVariable("team") PenaltyShootOut.Team team, @PathVariable("isGoal") boolean isGoal) {
        pso.recordScore(team, isGoal);
        if (pso.getWinner() != null) {
            return "Winner can be concluded now : " + pso.getWinner();
        } else {
            return "More input required ...\n" + pso.getScore();
        }
    }

    @RequestMapping("/winner")
    public String getWinner() {
        if (pso.getWinner() != null) {
            return "Winner can be concluded now : " + pso.getWinner();
        } else {
            return "Can not be concluded now !!";
        }
    }

    @RequestMapping(path = {"/reset/{rounds}", "/reset"})
    public String resetScore(@PathVariable(value = "rounds", required = false) Optional<Integer> rounds) {
        return pso.reset(rounds.orElse(5));
    }
}
