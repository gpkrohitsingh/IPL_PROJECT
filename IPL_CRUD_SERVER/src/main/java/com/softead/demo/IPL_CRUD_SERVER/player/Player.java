package com.softead.demo.IPL_CRUD_SERVER.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Value;

import com.softead.demo.IPL_CRUD_SERVER.team.Team;

@Entity
@Table(name = "PLAYER")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLAYER_ID")
	@Value("#{new Integer.parseDouble('${id}')}")
	private int id;
	@Column(name = "player_Name")
	private String playerName;
	@Column(name = "preference")
	private String preference;
	@Column(name = "match_played")
	private int matchesPlayed;
	@Column(name = "runs")
	private int runs;
	@Column(name = "wickets")
	private int wickets;
	@Column(name = "highest_score")
	private int highestScore;
	@Column(name = "best_wickets")
	private int bestWickets;
	@Column(name = "fifties")
	private int fifties;
	@Column(name = "centuries")
	private int centuries;
	@Column(name = "thirties")
	private int thirties;
	@Column(name = "catches")
	private int catches;
	@Column(name = "stumpings")
	private int stumpings;
	@Column(name = "foures")
	private int foures;
	@Column(name = "sixes")
	private int sixes;
	@Column(name = "strike_rate")
	private double strikeRate;
	@Column(name = "average")
	private double average;
	@Column(name = "team")
	private String team;
	
//	@ManyToOne
//	@JoinColumn(name = "team_id", nullable=false)
//	private Team team;
	
	public Player(){
		
	}

	public Player(int id, String playerName, String preference, int matchesPlayed, int runs, int wickets,
			int highestScore, int bestWickets, int fifties, int centuries, int thirties, int catches, int stumpings,
			int foures, int sixes, double strikeRate, double average, String team) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.preference = preference;
		this.matchesPlayed = matchesPlayed;
		this.runs = runs;
		this.wickets = wickets;
		this.highestScore = highestScore;
		this.bestWickets = bestWickets;
		this.fifties = fifties;
		this.centuries = centuries;
		this.thirties = thirties;
		this.catches = catches;
		this.stumpings = stumpings;
		this.foures = foures;
		this.sixes = sixes;
		this.strikeRate = strikeRate;
		this.average = average;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}

	public int getBestWickets() {
		return bestWickets;
	}

	public void setBestWickets(int bestWickets) {
		this.bestWickets = bestWickets;
	}

	public int getFifties() {
		return fifties;
	}

	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	public int getCenturies() {
		return centuries;
	}

	public void setCenturies(int centuries) {
		this.centuries = centuries;
	}

	public int getThirties() {
		return thirties;
	}

	public void setThirties(int thirties) {
		this.thirties = thirties;
	}

	public int getCatches() {
		return catches;
	}

	public void setCatches(int catches) {
		this.catches = catches;
	}

	public int getStumpings() {
		return stumpings;
	}

	public void setStumpings(int stumpings) {
		this.stumpings = stumpings;
	}

	public int getFoures() {
		return foures;
	}

	public void setFoures(int foures) {
		this.foures = foures;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
