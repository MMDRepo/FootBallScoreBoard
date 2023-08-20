package com.sr.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.sr.model.Match;

public class MatchService {

	public ArrayList<Match> getScoreBoardInformation(){
		return null;
		
	}

	public ArrayList<Match> startMatch(int matchId, ArrayList<Match> matchList){
		for(Match match: matchList){
			if(match.getMatchId()==matchId){
				match.setHomeTeamScore("0");
			    match.setAwayTeamScore("0");
			    match.setTotalScore(((Integer.parseInt(match.getHomeTeamScore())+Integer.parseInt(match.getAwayTeamScore()))));
			    match.setUpdatedTime(new Timestamp(new Date().getTime()));
			}
		}
		
		return matchList;
		
	}

	public ArrayList<Match> updateScore(int matchId, String homeTeamScore, String awayTeamScore, ArrayList<Match> matchList){
		for(Match match: matchList){
			if(match.getMatchId()==matchId){
				match.setHomeTeamScore(homeTeamScore);
				match.setAwayTeamScore(awayTeamScore);
				int totalScore =Integer.parseInt(homeTeamScore)+Integer.parseInt(awayTeamScore);
				match.setTotalScore(totalScore);
				match.setUpdatedTime(new Timestamp(new Date().getTime()));
				break;
			}
		}
			return matchList;
	}

	public ArrayList<Match> finishMatch(int matchId, ArrayList<Match> matchList){
		for(Match match: matchList){
			if(match.getMatchId()==matchId){
				matchList.remove(match);
				break;
			}
		}
		return matchList;
		
	}
	
	/*public ArrayList<Match> sortedList(ArrayList<Match> matchList){
	
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
		return matchList;
		
		
	}*/
	
}
