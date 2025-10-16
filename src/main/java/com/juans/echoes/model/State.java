package com.juans.echoes.model;

import java.util.Map;

public class State {
    private String id;
    private Map<String, Choice> choices;
    private boolean isEndState;

    public State(String id, Map<String, Choice> choices, boolean isEndState) {
        this.id = id;
        this.choices = choices;
        this.isEndState = isEndState;
    }

    public String getId() {
        return id;
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
}
