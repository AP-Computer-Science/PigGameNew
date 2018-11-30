package com.apcomputerscience.piggamenew.events;
import com.apcomputerscience.piggamenew.IGameWriter;
import com.apcomputerscience.piggamenew.GameEngine;
import com.apcomputerscience.piggamenew.GameEvent;

public class SumReduceEvent extends GameEvent{

    public static final String NAME = "OneEvent";
    IGameWriter writer;
    int max = 100;
    public SumReduceEvent(IGameWriter w, int m) {
        super(NAME);
        writer = w;
        max = m;
    }
    @Override
    public void CallEvent(GameEngine game) {
        writer.println(game.getPlayerCurrentName() + " reached the max of " + max + " per turn.");
        game.startNextTurn();
    }

    @Override
    public boolean shouldBeCalled(GameEngine game) {
        return game.getCurrentPlayerDieSum() >= max;
    }
}