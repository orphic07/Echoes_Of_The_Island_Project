package com.juans.echoes.model;

public class GameStats {
    private int gamesPlayed;
    private int deaths;
    private int endingACount;
    private int endingBCount;

    public GameStats(){
        this.gamesPlayed = 0;
        this.deaths = 0;
        this.endingACount = 0;
        this.endingBCount = 0;
    }

    public void increaseGamesPlayed() {
        gamesPlayed++;
    }

    public void increaseDeaths() {
        deaths++;
    }

    public void increaseEndingA() {
        endingACount++;
    }

    public void increaseEndingB() {
        endingBCount++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getEndingACount() {
        return endingACount;
    }

    public int getEndingBCount() {
        return endingBCount;
    }
}
