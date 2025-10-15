package com.juans.echoes.model;

public class Choice {
    private String text;
    private State nextState;

    public Choice(String text, State newState) {
        this.text = text;
        this.nextState = newState;
    }

    public void executeChoice(){

    }
}
