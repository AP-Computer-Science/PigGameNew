package com.apcomputerscience.piggamenew.events.eventBusEvents;

public class SnakeEyeEventBusEvent {
    private final String playerName;
    public SnakeEyeEventBusEvent(String p) {
        playerName = p;
    }
    public String getName() {
        return playerName;
    }
}