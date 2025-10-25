package com.juans.echoes.controller;

import com.juans.echoes.model.Choice;
import com.juans.echoes.model.GameStats;
import com.juans.echoes.model.Player;
import com.juans.echoes.model.State;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameEngine {
    private Player john;
    private Map<String, State> states;
    private GameStats stats;

    public GameEngine(){
        this.john = new Player();
        this.stats = new GameStats();
        this.states = new HashMap<>();
    }

    public void initializeGame(){

        john = new Player();

        Map<String, Choice> shoreChoices = new HashMap<>();
        Map<String, Choice> jungleChoices = new HashMap<>();
        Map<String, Choice> caveChoices = new HashMap<>();
        Map<String, Choice> ruinsChoices = new HashMap<>();

        states.put("Shore", new State("Shore", shoreChoices, false, "none"));
        states.put("Jungle", new State("Jungle", jungleChoices, false, "none"));
        states.put("Cave", new State("Cave", caveChoices, false, "none"));
        states.put("Ruins", new State("Ruins", ruinsChoices, false, "none"));
        states.put("End Cave", new State("EndCave", Collections.emptyMap(), true, "none"));
        states.put("Death", new State("Death", Collections.emptyMap(), true, "death"));

        shoreChoices.put("A", new Choice("Stay by the shore and build a fire. " +
                "Survival comes first — explore later, when you and Sam have your strength back", states.get("Jungle")));
        shoreChoices.put("B", new Choice("Head inland immediately, ignoring Sam’s warning. " +
                "Something about this island draws you in... " +
                "even as the air feels heavier with each step.", states.get("Death")));

        jungleChoices.put("A", new Choice("Follow the distant scream. Even though fear grips you both, " +
                "maybe someone is in danger and needs help", states.get("Death")));
        jungleChoices.put("B", new Choice("Avoid the direction of the scream. Trust your instincts, " +
                "and move through the trees in silence. That was definitely not human", states.get("Cave")));

        caveChoices.put("A", new Choice("Rest and set up camp inside the cave. The walls feel " +
                "safe enough to catch your breath", states.get("Ruins")));
        caveChoices.put("B", new Choice("Explore deeper into the tunnels before resting. The markings on the walls glow faintly… " +
                "curiosity pulling stronger than caution.", states.get("Ruins")));

        john.setCurrentState(states.get("Shore"));

    }

    public void processChoice(String choiceKey){

        State current = john.getCurrentState();

        if (current.getId().equals("Cave") && choiceKey.equals("B")) {
            john.setHasArtifact(true);
        }

        john.setCurrentState(current.getChoices().get(choiceKey).getNextState());

        State newState = john.getCurrentState();

        if (john.getCurrentState().getId().equals("Ruins")) {
            if (john.getHasArtifact()){
                Map<String, Choice> ruinsChoices = john.getCurrentState().getChoices();
                ruinsChoices.clear();
                ruinsChoices.put("A", new Choice("Place your fused artifact into the altar’s hollow core — " +
                        "its symbols are calling you, pulsing with light..", states.get("End Cave")));
                ruinsChoices.put("B", new Choice("Step back — the hum of power in the air twists your gut. " +
                        "Maybe some things aren’t meant to be touched.", states.get("End Cave")));
            } else {
                Map<String, Choice> ruinsChoices = john.getCurrentState().getChoices();
                ruinsChoices.clear();
                ruinsChoices.put("A", new Choice("Try to activate the altar manually. " +
                        "The carvings flicker faintly, something vital is missing, but why not give it a try?", states.get("End Cave")));
                ruinsChoices.put("B", new Choice("Step away from the altar. Whatever built this place —" +
                        " it didn’t want to be disturbed.", states.get("End Cave")));
            }
        }

        if (current.getId().equals("Ruins") && current.getChoices().containsKey(choiceKey)) {
            if (john.getHasArtifact() && choiceKey.equals("A")) {
                current.getChoices().get(choiceKey).getNextState().setEndType("goodArtifact");
            } else if (john.getHasArtifact() && choiceKey.equals("B")) {
                current.getChoices().get(choiceKey).getNextState().setEndType("neutralArtifact");
            } else if (!john.getHasArtifact() && choiceKey.equals("A")) {
                current.getChoices().get(choiceKey).getNextState().setEndType("badNoArtifact");
            } else if (!john.getHasArtifact() && choiceKey.equals("B")) {
                current.getChoices().get(choiceKey).getNextState().setEndType("neutralNoArtifact");
            }
        }

        if (newState.isEndState()) {
            switch (newState.getEndType()) {
                case "death" -> { john.setAlive(false); stats.increaseDeaths(); stats.increaseGamesPlayed();}
                case "goodArtifact" -> { stats.increaseGamesPlayed(); stats.increaseEndingA(); }
                case "neutralArtifact" -> { stats.increaseGamesPlayed(); stats.increaseEndingB(); }
                case "badNoArtifact" -> { stats.increaseGamesPlayed(); stats.increaseEndingC(); }
                case "neutralNoArtifact" -> { stats.increaseGamesPlayed();stats.increaseEndingD(); }
            }
        } else {
            System.out.println("Moved to state: " + newState.getId());
        }

    }

    public void restartGame(){
        initializeGame();
        john = new Player();
        john.setAlive(true);
        john.setCurrentState(states.get("Shore"));
        john.setHasArtifact(false);
        stats.increaseGamesPlayed();

    }

    public Player getJohn() {
        return john;
    }

    public GameStats getStats(){
        return stats;
    }

    public Map<String, State> getStates() {
        return states;
    }
}
