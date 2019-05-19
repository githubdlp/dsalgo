package com.dlp.java;

import org.junit.Assert;

import static org.junit.Assert.*;

public class PenaltyShootOutTest {

    @org.junit.Test
    public void getWinner_NoScore() {
        PenaltyShootOut pso = new PenaltyShootOut();
        Assert.assertNull(pso.getWinner());
    }

    @org.junit.Test
    public void getWinner_OneScore() {
        PenaltyShootOut pso = new PenaltyShootOut();
        pso.recordScore(PenaltyShootOut.Team.A, true);
        Assert.assertNull(pso.getWinner());
    }

    @org.junit.Test
    public void getWinner_MutlipleScore2() {
        PenaltyShootOut pso = new PenaltyShootOut();
        pso.recordScore(PenaltyShootOut.Team.A, true);
        pso.recordScore(PenaltyShootOut.Team.B, false);
        pso.recordScore(PenaltyShootOut.Team.A, true);
        pso.recordScore(PenaltyShootOut.Team.B, false);
        pso.recordScore(PenaltyShootOut.Team.A, true);
        Assert.assertNull(pso.getWinner());
    }

    @org.junit.Test
    public void getWinner_MutlipleScore1() {
        PenaltyShootOut pso = new PenaltyShootOut();
        pso.recordScore(PenaltyShootOut.Team.A, true);
        pso.recordScore(PenaltyShootOut.Team.B, false);
        pso.recordScore(PenaltyShootOut.Team.A, true);
        pso.recordScore(PenaltyShootOut.Team.B, false);
        pso.recordScore(PenaltyShootOut.Team.A, true);
        pso.recordScore(PenaltyShootOut.Team.B, false);
        Assert.assertEquals(PenaltyShootOut.Team.A, pso.getWinner());
    }
}