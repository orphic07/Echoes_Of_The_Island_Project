package com.juans.echoes.model;

import java.util.List;
import java.util.Map;

public class State {
    private String id;
    private String description;
    private Map<String, Choice> choices;

    public State(String id, String description, Map<String, Choice> choices) {
        this.id = id;
        this.description = description;
        this.choices = choices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
