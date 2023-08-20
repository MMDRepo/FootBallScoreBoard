package com.sr.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
 

import com.sr.model.Match;
import com.sr.model.ScoreBoard;
@Controller
public class MatchController {
		
	    private ScoreBoard scoreBoard= new ScoreBoard(new ArrayList<Match>());
	    
	    @RequestMapping("/")
	    public String getDashboardData(Model model) {
	     
	    	//scoreBoard.setMatchList(new ArrayList<Match>());
	    	if(scoreBoard.getMatchList().size()==0){
	    	Match m1= new Match(1, "Match1", "Mexico", "Canada", "", "", "");
	    	Match m2= new Match(2, "Match2", "Spain", "Brazil", "", "", "");
	    	Match m3= new Match(3, "Match3", "Germany", "France", "", "", "");
	    	Match m4= new Match(4, "Match4", "Uruguay", "Italy", "", "", "");
	    	Match m5= new Match(5, "Match5", "Argentina", "Australia", "", "", "");
	    	Match m6= new Match(6, "Match6", "India", "Australia", "", "", "");
	    	Match m7= new Match(7, "Match7", "Brazil", "Canada", "", "", "");
	    	
	    	scoreBoard.getMatchList().add(m1);
	    	scoreBoard.getMatchList().add(m2);
	    	scoreBoard.getMatchList().add(m3);
	    	scoreBoard.getMatchList().add(m4);
	    	scoreBoard.getMatchList().add(m5);
	    	scoreBoard.getMatchList().add(m6);
	    	scoreBoard.getMatchList().add(m7);
	    	}
	    
	    	model.addAttribute("matchList", scoreBoard);
	    	
	        
	        return "/";
	    }

	    @RequestMapping("/startGame")
	    public ArrayList<Match> startGame(@RequestParam("id") String id,
	                            @RequestParam("homeTeam") String homeTeam,
	                            @RequestParam("awayTeam") String awayTeam) {
	    	
			
	    	return scoreBoard.getMatchList();
	        // Logic to start a game using the ScoreBoard class
	        // Redirect to the dashboard page
	    }

	    @RequestMapping("/updateScore")
	    public ArrayList<Match> updateScore(@RequestParam("name") String name,
	                              @RequestParam("homeTeamScore") int homeTeamScore,
	                              @RequestParam("awayTeamScore") int awayTeamScore) {
	        // Logic to update the score of a game using the ScoreBoard class
	        // Redirect to the dashboard page
	    	return scoreBoard.getMatchList();
	    }

	    @RequestMapping("/finishGame")
	    public ArrayList<Match> finishGame(@RequestParam("name") String name) {
	        // Logic to finish a game using the ScoreBoard class
	        // Redirect to the dashboard page
	    	return scoreBoard.getMatchList();
	    }

	    @RequestMapping("/dashboard")
	    public ArrayList<Match> getDashboard(Model model) {
	        // Logic to retrieve the game details from the ScoreBoard class and pass it to the JSP
	        // Return the dashboard page
	    	return scoreBoard.getMatchList();
	    }
	}


