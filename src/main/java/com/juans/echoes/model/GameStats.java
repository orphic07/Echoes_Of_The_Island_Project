package com.juans.echoes.model;

public class GameStats {
    private int gamesPlayed;
    private int deaths;
    private int endingACount;
    private int endingBCount;
    private int endingCCount;
    private int endingDCount;

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

    public void increaseEndingC() {
        endingCCount++;
    }

    public void increaseEndingD(){
        endingDCount++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getEndingA() {
        return endingACount;
    }

    public int getEndingB() {
        return endingBCount;
    }

    public int getEndingC() {
        return endingCCount;
    }

    public int getEndingD() {
        return endingDCount;
    }
}
