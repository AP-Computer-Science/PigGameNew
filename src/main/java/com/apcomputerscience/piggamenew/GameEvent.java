package com.apcomputerscience.piggamenew;

public abstract class GameEvent {
    private boolean enabled = true;
    private static boolean endTasks = false;
    protected boolean alwaysExecute = false;
    private final String eventName;
    public boolean isEnabled() {
        return enabled;
    }
    public void setStatus(boolean e) {
        enabled = e;
    }
    protected GameEvent(String n) {
        eventName = n;
    }
    public String getEventName() {
        return eventName;
    }
    public abstract void CallEvent(GameEngine game);
    public abstract boolean shouldBeCalled(GameEngine game);
    public static boolean shouldEndTasks() {
        return endTasks;
    }
    protected void endNextTasks() {
        if(!alwaysExecute) {
            endTasks = false;
        }
    }
}