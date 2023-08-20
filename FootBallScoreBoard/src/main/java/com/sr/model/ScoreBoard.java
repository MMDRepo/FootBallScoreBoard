package com.sr.model;

import java.util.ArrayList;

public class ScoreBoard {
	private ArrayList<Match> matchList;

	public ScoreBoard(ArrayList<Match> matchList) {
		super();
		this.matchList = matchList;
	}

	public ArrayList<Match> getMatchList() {
		return matchList;
	}

	public void setMatchList(ArrayList<Match> matchList) {
		this.matchList = matchList;
	}
	
	
	
}
