package com.juans.echoes.controller;

import com.juans.echoes.model.GameStats;
import com.juans.echoes.model.Player;
import com.juans.echoes.model.State;

import java.util.HashMap;
import java.util.Map;

public class GameEngine {
    private Player player;
    private Map<String, State> states;
    private GameStats stats;

    public GameEngine(){
        this.player = new Player();
        this.stats = new GameStats();
        this.states = new HashMap<>();
    }

    public void initializeGame(){

    }

    public void processChoice(String choiceKey){

    }

    public void restartGame(){

    }

}
