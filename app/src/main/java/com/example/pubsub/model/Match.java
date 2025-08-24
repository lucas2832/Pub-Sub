package com.example.pubsub.model;

public class Match {
    private Team homeTeam;
    private Team awayTeam;
    private Score score;
    private String matchName;
    private String status;

    // Getters e Setters
    public Team getHomeTeam() { return homeTeam; }
    public void setHomeTeam(Team homeTeam) { this.homeTeam = homeTeam; }

    public Team getAwayTeam() { return awayTeam; }
    public void setAwayTeam(Team awayTeam) { this.awayTeam = awayTeam; }

    public Score getScore() { return score; }
    public void setScore(Score score) { this.score = score; }

    public String getMatchName() { return matchName; }
    public void setMatchName(String matchName) { this.matchName = matchName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

