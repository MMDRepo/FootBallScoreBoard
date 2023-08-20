package com.sr.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class MatchControllerTest {

    private MatchController matchController;

    @Mock
    private HttpServletRequest request;

    @Mock
    private Model model;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        matchController = new MatchController();
    }

    @Test
    public void testGetDashboardData() {
        String expectedViewName = "/";

        String actualViewName = matchController.getDashboardData(model);

        assertEquals(expectedViewName, actualViewName);
        verify(model).addAttribute(eq("matchList"), anyList());
    }

    @Test
    public void testStartMatch() {
        int matchId = 1;

        String actualViewName = matchController.startMatch(request, model);

        assertEquals("/", actualViewName);
        verify(model).addAttribute(eq("matchList"), anyList());
    }

    @Test
    public void testUpdatePage() {
        int matchId = 1;
        String homeTeamScore = "2";
        String awayTeamScore = "1";

        String actualViewName = matchController.updatePage(request, model);

        assertEquals("updateScore", actualViewName);
        verify(model).addAttribute("matchId", matchId);
        verify(model).addAttribute("homeTeamScore", parseInteger(homeTeamScore));
        verify(model).addAttribute("awayTeamScore", parseInteger(awayTeamScore));
        verify(model).addAttribute(eq("matchList"), anyList());
    }

    @Test
    public void testUpdateScore() {
        int matchId = 1;
        String homeTeamScore = "2";
        String awayTeamScore = "1";

        String actualViewName = matchController.updateScore(request, model);

        assertEquals("/", actualViewName);
        verify(model).addAttribute(eq("matchList"), anyList());
    }

    @Test
    public void testFinishGame() {
        int matchId = 1;

        String actualViewName = matchController.finishGame(request, model);

        assertEquals("/", actualViewName);
        verify(model).addAttribute(eq("matchList"), anyList());
    }

    private static Integer parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
