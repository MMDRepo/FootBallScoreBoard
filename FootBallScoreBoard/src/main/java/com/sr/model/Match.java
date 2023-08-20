package com.sr.model;
public class Match {
	private int matchId;
	private String matchName;
	private String homeTeamName;
	private String awayTeamName;
	private String homeTeamScore;
	private String awayTeamScore;
	private String totalScore;
	private String updatedTime;
	
	
	public Match(int matchId, String matchName, String homeTeamName, String awayTeamName, String homeTeamScore,
			String awayTeamScore, String totalScore) {
		super();
		this.matchId = matchId;
		this.matchName = matchName;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.totalScore = totalScore;
	}
	
	
	public Match(int matchId, String matchName, String homeTeamName, String awayTeamName, String homeTeamScore,
			String awayTeamScore, String totalScore, String updatedTime) {
		super();
		this.matchId = matchId;
		this.matchName = matchName;
		this.homeTeamName = homeTeamName;
		this.awayTeamName = awayTeamName;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.totalScore = totalScore;
		this.updatedTime = updatedTime;
	}


	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	public String getHomeTeamName() {
		return homeTeamName;
	}
	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}
	public String getAwayTeamName() {
		return awayTeamName;
	}
	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}
	public String getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(String homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	public String getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(String awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	
}
