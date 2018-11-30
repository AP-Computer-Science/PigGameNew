package com.apcomputerscience.piggamenew;

/**
 *
 * @author gamec
 */
public class StandordPlayerOperations implements IPlayerOperation {

    private final IGameWriter writer;
    public StandordPlayerOperations(IGameWriter w) {
        writer = w;
    }
    @Override
    public void contueRoll() {
        GameEngine.Current.currentPlayerRoll();
        GameEngine.Current.checkEvents();
        displayPlayerValues();
    }
    private void displayPlayerValues() {
        writer.println(GameEngine.Current.getTurnNumber() + ": " + GameEngine.Current.getPlayerCurrentName() + "'s" +
                " score is " + GameEngine.Current.getCurrentPlayerScore() +
                ", and current sum is " + GameEngine.Current.getCurrentPlayerDieSum() + ".");
    }

    @Override
    public void stop() {
        writer.println(GameEngine.Current.getPlayerCurrentName() + " skipped his turn.");
        GameEngine.Current.startNextTurn();
        displayPlayerValues();
    }

    @Override
    public void speak(String message) {
        
    }
}