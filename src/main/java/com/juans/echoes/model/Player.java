package com.juans.echoes.model;

public class Player {
    private State currentState;
    private boolean hasArtifact;
    private boolean isAlive;
    private String lastStateId;

    public Player() {
        this.hasArtifact = false;
        this.isAlive = true;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        if (this.currentState != null) {
            this.lastStateId = this.currentState.getId();
        }
        this.currentState = currentState;

    }

    public String getLastStateId() {
        return lastStateId;
    }

    public boolean getHasArtifact() {
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
