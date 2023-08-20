package com.sr.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sr.model.Match;
import com.sr.model.ScoreBoard;
import com.sr.service.MatchService;
@Controller
public class MatchController{
		
	
		
		private  ArrayList<Match> matchList= new ArrayList<Match>();
	    private ScoreBoard scoreBoard= new ScoreBoard(matchList);
	    
	    @RequestMapping("/")
	    public String getDashboardData(Model model) {
	     
	    	//scoreBoard.setMatchList(new ArrayList<Match>());
	    	if(matchList.size()==0){
	    	Match m1= new Match(1, "Match1", "Mexico", "Canada", "", "", 0);
	    	Match m2= new Match(2, "Match2", "Spain", "Brazil", "", "", 0);
	    	Match m3= new Match(3, "Match3", "Germany", "France", "", "", 0);
	    	Match m4= new Match(4, "Match4", "Uruguay", "Italy", "", "", 0);
	    	Match m5= new Match(5, "Match5", "Argentina", "Australia", "", "", 0);
	    	Match m6= new Match(6, "Match6", "India", "Australia", "", "", 0);
	    	Match m7= new Match(7, "Match7", "Brazil", "Canada", "", "", 0);
	    	
	    	scoreBoard.getMatchList().add(m1);
	    	scoreBoard.getMatchList().add(m2);
	    	scoreBoard.getMatchList().add(m3);
	    	scoreBoard.getMatchList().add(m4);
	    	scoreBoard.getMatchList().add(m5);
	    	scoreBoard.getMatchList().add(m6);
	    	scoreBoard.getMatchList().add(m7);
	    	}
	    	else{
	    		
	    		matchList= scoreBoard.getMatchList();
	    		
	    		Collections.sort(matchList, new Comparator<Match>() {
	                @Override
	                public int compare(Match match1, Match match2) {
	                    // Compare the total scores
	                    int totalScoreComparison = Integer.compare(match2.getTotalScore(), match1.getTotalScore());
	                    if (totalScoreComparison != 0) {
	                        return totalScoreComparison;
	                    }

	                    // If the total scores are the same, compare the updated times
	                    return match2.getUpdatedTime().compareTo(match1.getUpdatedTime());
	                }
	            });
	    		scoreBoard.setMatchList(matchList);
	    	}
	    
	    	model.addAttribute("matchList", matchList);
	    	
	        
	        return "/";
	    }

	    @RequestMapping(value="/startMatch", method = RequestMethod.POST)
	    public String startMatch(HttpServletRequest request, Model model) {
	    	MatchService service= new MatchService();
	    	int matchId = Integer.parseInt(request.getParameter("matchId"));
	    	matchList = service.startMatch(matchId,matchList);
			
	    	model.addAttribute("matchList", matchList);
	    	return "/";
	    }
	    
	    @RequestMapping(value="/updatePage", method = RequestMethod.POST)
	    public String updatePage(HttpServletRequest request, Model model) {
	    	MatchService service= new MatchService();
	    	int matchId = Integer.parseInt(request.getParameter("matchId"));
	    	int homeTeamScore =  Integer.parseInt(request.getParameter("homeTeamScore"));
	    	int awayTeamScore =  Integer.parseInt(request.getParameter("awayTeamScore"));
	    	matchList = service.startMatch(matchId,matchList);
			
	    	
	    	model.addAttribute("matchId", matchId);
	    	model.addAttribute("matchList", matchList);
	    	model.addAttribute("homeTeamScore", homeTeamScore);
	    	model.addAttribute("awayTeamScore", awayTeamScore);
	    	model.addAttribute("matchList", matchList);
	    	return "updateScore";
	    }

	    @RequestMapping(value="/updateScore", method = RequestMethod.POST)
	    public String updateScore(HttpServletRequest request, Model model) {
	    	MatchService service= new MatchService();
	    	int matchId = Integer.parseInt(request.getParameter("matchId"));
	    	String homeTeamScore=request.getParameter("homeTeamScore");
	    	String awayTeamScore= request.getParameter("awayTeamScore");
	    	matchList = service.updateScore(matchId, homeTeamScore, awayTeamScore, matchList);
			
	    	model.addAttribute("matchList", matchList);
	    	return "/";
	    }

	    @RequestMapping(value="/finishMatch", method = RequestMethod.POST)
	    public String finishGame(HttpServletRequest request, Model model) {
	    	MatchService service= new MatchService();
	    	int matchId = Integer.parseInt(request.getParameter("matchId"));
	    	matchList = service.finishMatch(matchId,matchList);
			
	    	model.addAttribute("matchList", matchList);
	    	return "/";
	    }

	    
}


