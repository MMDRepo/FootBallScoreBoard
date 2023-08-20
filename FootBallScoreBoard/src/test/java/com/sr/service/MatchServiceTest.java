package com.sr.service;

import java.util.ArrayList;

import com.sr.model.Match;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class MatchServiceTest {
    private MatchService matchService;
    private ArrayList<Match> matchList;

    @Before
    public void setUp() {
        matchService = new MatchService();
        matchList = new ArrayList<>();
        matchList.add(new Match(1,"Match1", "Home Team 1", "Away Team 1", "0", "0",1));
        matchList.add(new Match(2, "Match2","Home Team 2", "Away Team 2", "0", "0",1));
    }

    @Test
    public void testStartMatch() {
        ArrayList<Match> updatedMatchList = matchService.startMatch(1, matchList);
        Match match = updatedMatchList.get(0);
        assertEquals("0", match.getHomeTeamScore());
        assertEquals("0", match.getAwayTeamScore());
        assertEquals(0, match.getTotalScore());
        assertNotNull(match.getUpdatedTime());
    }

    @Test
    public void testUpdateScore() {
        ArrayList<Match> updatedMatchList = matchService.updateScore(1, "2", "1", matchList);
        Match match = updatedMatchList.get(0);
        assertEquals("2", match.getHomeTeamScore());
        assertEquals("1", match.getAwayTeamScore());
        assertEquals(3, match.getTotalScore());
        assertNotNull(match.getUpdatedTime());
    }

    @Test
    public void testFinishMatch() {
        ArrayList<Match> updatedMatchList = matchService.finishMatch(1, matchList);
        assertEquals(1, updatedMatchList.size());
        assertEquals(2, updatedMatchList.get(0).getMatchId());
    }
}