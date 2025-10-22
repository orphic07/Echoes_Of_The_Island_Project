package com.juans.echoes.model;

import java.util.Map;

public class State {
    private String id;
    private Map<String, Choice> choices;
    private boolean isEndState;
    private String endType;

    public State(String id, Map<String, Choice> choices, boolean isEndState, String endType) {
        this.id = id;
        this.choices = choices;
        this.isEndState = isEndState;
        this.endType = endType;
    }

    public String getId() {
        return id;
    }

    public String getEndType() {
        return endType;
    }

    public void setEndType(String endType) {
        this.endType = endType;
    }

    public void setEndState(boolean endState) {
        isEndState = endState;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addChoice(String key, Choice choice) {
        choices.put(key, choice);
    }

    public Map<String, Choice> getChoices() {
        return choices;
    }

    public void setChoices(Map<String, Choice> choices) {
        this.choices = choices;
    }

    public boolean isEndState() {
        return isEndState;
    }
}
