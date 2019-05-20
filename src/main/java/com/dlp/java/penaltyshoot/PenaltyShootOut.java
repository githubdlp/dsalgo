package com.dlp.java.penaltyshoot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Class to handle penalty shootout events in sports.
 * After creation of an instance, input the goal using recordScore()
 */
@Component
@Scope("singleton")
public class PenaltyShootOut {


    public enum Team {
        A, B
    }

    public static final int DEFAULT_ROUNDS = 5;
    private int rounds = DEFAULT_ROUNDS;
    private int teamAGoal = 0, teamBGoal = 0;
    private int teamAShootRemaining = rounds, teamBShootRemaining = rounds;

    public void reset() {
        this.reset(DEFAULT_ROUNDS);
    }

    /**
     * reset the instance with custom number of rounds
     *
     * @param rounds
     */
    public String reset(int rounds) {
        this.rounds = rounds;
        this.teamAGoal = 0;
        this.teamBGoal = 0;
        this.teamAShootRemaining = rounds;
        this.teamBShootRemaining = rounds;
        return "Reset done for rounds : " + rounds;
    }

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

    public String getScore() {
        return "Current Score : \n" + "Team A : " + teamAGoal + " remaining shoot : " + teamAShootRemaining + "\nTeam B : " + teamBGoal + " remaining shoot : " + teamBShootRemaining;
    }
}
