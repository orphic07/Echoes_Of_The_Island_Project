package com.juans.echoes.model;

public class Choice {
    private String text;
    private State nextState;

    public Choice(String text, State newState) {
        this.text = text;
        this.nextState = newState;
    }

    public String getText() {
        return text;
    }

    public State getNextState() {
        return nextState;
    }

    @Override
    public String toString(){
        return text;
    }
}
