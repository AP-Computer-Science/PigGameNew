package com.apcomputerscience.piggamenew.events;

import com.apcomputerscience.piggamenew.GameEngine;
import com.apcomputerscience.piggamenew.GameEvent;
import com.apcomputerscience.piggamenew.IGameWriter;
import org.fusesource.jansi.Ansi;

public class OneEvent extends GameEvent {
    public static final String NAME = "OneEvent";
    private IGameWriter writer;
    public OneEvent(IGameWriter w) {
        super(NAME);
        writer = w;
    }
    @Override
    public void CallEvent(GameEngine game) {
        writer.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a(game.getPlayerCurrentName() + " rolled a one. He skips his turn and lost " + game.getCurrentPlayerDieSum() + " points.").reset());
        game.revertChanges();
        game.startNextTurn();
    }

    @Override
    public boolean shouldBeCalled(GameEngine game) {
        return game.getCurrentPlayerDiceValue1() == 1 || game.getCurrentPlayerDiceValue2() == 1;
    }

    @Override
    public void init() {

    }
}