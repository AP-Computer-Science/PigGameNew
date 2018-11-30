package com.apcomputerscience.piggamenew.events;
import com.apcomputerscience.piggamenew.GameEngine;
import com.apcomputerscience.piggamenew.GameEvent;
import com.apcomputerscience.piggamenew.IGameWriter;

public class SnakeEyeEvent extends GameEvent{

    public static final String NAME = "OneEvent";
    IGameWriter writer;
    public SnakeEyeEvent(IGameWriter w) {
        super(NAME);
        writer = w;
    }
    @Override
    public void CallEvent(GameEngine game) {
        writer.println(game.getPlayerCurrentName() + " rolled snake eyes. He loses all his points.");
        game.getEventBus().post(new com.apcomputerscience.piggamenew.events.eventBusEvents.SnakeEyeEventBusEvent(game.getPlayerCurrentName()));
        game.setCurrentPlayerScore(0);
    }

    @Override
    public boolean shouldBeCalled(GameEngine game) {
        return game.getCurrentPlayerDiceValue1() == 1 && game.getCurrentPlayerDiceValue2() == 1;
    }

    @Override
    public void init() {

    }
}