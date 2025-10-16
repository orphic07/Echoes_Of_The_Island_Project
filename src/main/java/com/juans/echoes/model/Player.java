package com.juans.echoes.model;

public class Player {
    private State currentState;
    private boolean hasArtifact;
    private boolean isAlive;

    public Player() {
        this.hasArtifact = false;
        this.isAlive = true;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public boolean hasArtifact() {
        return hasArtifact;
    }

    public void setHasArtifact(boolean hasArtifact) {
        this.hasArtifact = hasArtifact;

    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
