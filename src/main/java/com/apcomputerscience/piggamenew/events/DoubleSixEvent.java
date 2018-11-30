package com.apcomputerscience.piggamenew.events;

import com.apcomputerscience.piggamenew.GameEngine;
import com.apcomputerscience.piggamenew.GameEvent;
import com.apcomputerscience.piggamenew.IGameWriter;

public class DoubleSixEvent extends GameEvent {

    public static final String NAME = "OneEvent";
    private IGameWriter writer;
    public DoubleSixEvent(IGameWriter w) {
        super(NAME);
        writer = w;
    }
    @Override
    public void CallEvent(GameEngine game) {
        writer.println("Oh, No!!!! You just gave " + game.peakNextPlayer().getPlayerName() + " " + game.getCurrentPlayerScore() + " points!!!!");
        game.peakNextPlayer().addScore(game.getCurrentPlayerScore());
        game.setCurrentPlayerScore(0);
        game.startNextTurn();
    }

    @Override
    public boolean shouldBeCalled(GameEngine game) {
        return game.getCurrentPlayerDiceValue1() == 6 && game.getCurrentPlayerDiceValue2() == 6;
    }

    @Override
    public void init() {

    }
    
}
