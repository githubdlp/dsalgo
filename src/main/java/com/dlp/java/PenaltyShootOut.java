package com.dlp.java;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Class to handle penalty shootout events in sports.
 * After creation of an instance, input the goal using recordScore()
 */
@Component
@Scope("prototype")
public class PenaltyShootOut {

    enum Team {
        A, B
    }

    public static final int ROUNDS = 5;
    private int teamAGoal = 0, teamBGoal = 0;
    private int teamAShootRemaining = ROUNDS, teamBShootRemaining = ROUNDS;

    public void recordScore(Team team, boolean isGoal) {
        if (team == null) {
            System.out.println("Please enter correct team");
            return;
        }

        if (team == Team.A && teamAShootRemaining <= 0) {
            System.out.println("Invalid entry. No more shoot out remaining for Team A");
        }

        if (team == Team.B && teamBShootRemaining <= 0) {
            System.out.println("Invalid entry. No more shoot out remaining for Team B");
        }

        if (isGoal) {
            if (team == Team.A) {
                teamAGoal++;
            } else {
                teamBGoal++;
            }
        }

        decrementRemaining(team);

        if (getWinner() != null) {
            System.out.println("Team " + getWinner() + " is the winner");
        }
    }

    private boolean canConclude() {
        return (teamAGoal - teamBGoal > teamBShootRemaining || teamBGoal - teamAGoal > teamAShootRemaining) ? true : false;
    }

    private void decrementRemaining(Team team) {
        if (team == Team.A) {
            teamAShootRemaining--;
        } else {
            teamBShootRemaining--;
        }
    }

    /**
     * Gives the winner team if the game can be concluded.
     * null otherwise.
     *
     * @return
     */
    public Team getWinner() {
        if (canConclude()) {
            return teamAGoal - teamBGoal > 0 ? Team.A : Team.B;
        }
        return null;
    }
}
