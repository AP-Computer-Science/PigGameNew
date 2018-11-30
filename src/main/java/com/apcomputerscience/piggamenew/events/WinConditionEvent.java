package com.apcomputerscience.piggamenew.events;
import com.apcomputerscience.piggamenew.IGameWriter;
import com.apcomputerscience.piggamenew.GameEngine;
import com.apcomputerscience.piggamenew.GameEvent;

public class WinConditionEvent extends GameEvent{

    public static final String NAME = "OneEvent";
    IGameWriter writer;
    int max = 100;
    public WinConditionEvent(IGameWriter w, int m) {
        super(NAME);
        writer = w;
        max = m;
        super.alwaysExecute = true;
    }
    @Override
    public void CallEvent(GameEngine game) {
        game.setCurrentPlayerAsWinner();
    }

    @Override
    public boolean shouldBeCalled(GameEngine game) {
        return game.getCurrentPlayerScore() >= max;
    }
}