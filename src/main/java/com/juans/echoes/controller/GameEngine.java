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
        Map<String, Choice> endCaveChoices = new HashMap<>();

        states.put("Shore", new State("Shore", shoreChoices, false, "none"));
        states.put("Jungle", new State("Jungle", jungleChoices, false, "none"));
        states.put("Cave", new State("Cave", caveChoices, false, "none"));
        states.put("Ruins", new State("Ruins", ruinsChoices, false, "none"));
        states.put("End Cave", new State("End Cave", endCaveChoices, false, "none"));
        states.put("Death Shore", new State("Death Shore", Collections.emptyMap(), true, "death"));
        states.put("Death Jungle", new State("Death Jungle", Collections.emptyMap(), true, "death"));
        states.put("Death EndCave", new State("Death EndCave", Collections.emptyMap(), true, "death"));
        states.put("Ending A", new State("Ending A", Collections.emptyMap(), true, "endingA"));
        states.put("Ending B", new State("Ending B", Collections.emptyMap(), true, "endingB"));

        shoreChoices.put("A", new Choice("Stay by the shore and build a fire. " +
                "Survival comes first — explore later, when you and Sam have your strength back", states.get("Jungle")));
        shoreChoices.put("B", new Choice("Head inland immediately, ignoring Sam’s warning. " +
                "Something about this island draws you in... " +
                "even as the air feels heavier with each step.", states.get("Death Shore")));

        jungleChoices.put("A", new Choice("Follow the distant scream. Even though fear grips you both, " +
                "curiosity still wins over caution.", states.get("Death Jungle")));
        jungleChoices.put("B", new Choice("Avoid the direction of the scream. Trust your instincts, " +
                "and move through the trees in silence.", states.get("Cave")));
        jungleChoices.put("C", new Choice("Climb one of the towering trees. A higher view might reveal something" +
                " — or someone — nearby.", states.get("Cave")));

        caveChoices.put("A", new Choice("Rest and set up camp inside the cave. The walls feel " +
                "safe enough to catch your breath", states.get("Ruins")));
        caveChoices.put("B", new Choice("Explore deeper into the tunnels before resting. The unknown calls " +
                "stronger than the need for rest.", states.get("Ruins")));

        ruinsChoices.put("A", new Choice("Inspect the strange portal carved into the stone. " +
                "Its symbols seem to move under the light.", states.get("End Cave")));
        ruinsChoices.put("B", new Choice("Search the ruins carefully. Every wall hides stories — maybe even answers.", states.get("End Cave")));

        endCaveChoices.put("A", new Choice("Use the artifact to awaken the portal. " +
                "Whatever lies beyond must be faced", states.get("Ending A")));
        endCaveChoices.put("B", new Choice("Attempt to open the portal manually. There’s no time to hesitate now.", states.get("Ending B")));
        endCaveChoices.put("C", new Choice("Turn back before it’s too late. The cave trembles, and fear takes over.", states.get("Death EndCave")));

        john.setCurrentState(states.get("Shore"));

    }

    public void processChoice(String choiceKey){
        john.setCurrentState(
                john.getCurrentState().getChoices().get(choiceKey).getNextState()
        );
        System.out.println("Current state: " + john.getCurrentState().getId());

        State current = john.getCurrentState();

        if (current.isEndState()){
            // To do: restartGame() once player chooses to try again
            switch(current.getEndType()){
                case "death" -> { john.setAlive(false); stats.increaseDeaths();}
                case "endingA" -> stats.increaseEndingA();
                case "endingB" -> stats.increaseEndingB();
            }
        } else {
            System.out.println("Moved to state: " + current.getId());
        }
    }

    public void restartGame(){
        john.setAlive(true);
        john.setCurrentState(states.get("shore"));
        john.setHasArtifact(false);
        stats.increaseGamesPlayed();

    }

    public Player getJohn() {
        return john;
    }
}
