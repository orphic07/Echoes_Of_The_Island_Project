package com.juans.echoes;

import com.juans.echoes.controller.GameEngine;
import com.juans.echoes.model.Player;
import com.juans.echoes.model.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GameEngineTest {

    private GameEngine engine;

    @BeforeEach
    public void setUp(){
        engine = new GameEngine();
        engine.initializeGame();
    }

    @Test
    public void testInitializeGame_InitializeEverythingProperly(){
        engine.initializeGame();

        Player player = engine.getJohn();
        Map<String, State> states = engine.getStates();

        assertNotNull(player, "Player should be created during initialization");
        assertTrue(player.isAlive(), "Player should be alive during initialization");
        assertEquals("shore", player.getCurrentState().getId().toLowerCase(), "Player should start at the shore in the beginning of the game");
        assertFalse(player.getHasArtifact(), "Player should NOT have the artifact during initialisation");
        assertFalse(states.isEmpty(), "Game states shoule be created during initialization");
    }

    @Test
    public void testProcessChoice_GivesArtifactWhenExploringCave(){
        Player player = engine.getJohn();
        player.setCurrentState(engine.getStates().get("Cave"));

        engine.processChoice("B");

        assertTrue(player.getHasArtifact(), "Player should have artifact after exploring the cave.");

    }

    @Test
    public void testRestartGame_ResetsPlayerProperly(){
        Player player = engine.getJohn();
        player.setCurrentState(engine.getStates().get("Ruins"));
        player.setHasArtifact(true);

        engine.restartGame();
        player = engine.getJohn();

        assertEquals("shore", player.getCurrentState().getId().toLowerCase(), "Game should start back at the shore");
        assertFalse(player.getHasArtifact(), "Player SHOULD NOT keep the artifact after restarting.");
    }

    @Test
    public void testStats_IncrementDeaths(){
        Player player = engine.getJohn();
        int deathsBefore = engine.getStats().getDeaths();

        player.setAlive(false);
        engine.getStats().increaseDeaths();

        assertEquals(deathsBefore + 1, engine.getStats().getDeaths(), "Death counter should be increased by 1");
    }

    @Test
    public void testStats_IncrementGamesPlayed(){
        Player player = engine.getJohn();
        int gamesBefore = engine.getStats().getGamesPlayed();

        engine.getStats().increaseGamesPlayed();

        assertEquals(gamesBefore + 1, engine.getStats().getGamesPlayed(), "Games Played counter should be increased by 1 after each run");
    }

}
