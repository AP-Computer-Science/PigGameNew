package com.apcomputerscience.piggamenew;

import java.util.ArrayList;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

public class GameEngine {
    public static GameEngine Current;
    private GameState state;
    private final IGameWriter writer;
    private final ArrayList<Player> players;
    private final ArrayList<GameEvent> events;
    private int numOfPlayers;
    private int playerPositionIndex = -1;
    private int currentDieSum = 0;
    private IPlayerOperation playOp;
    private Player currentPlayer;
    private int turnNumber;
    public GameEngine(IGameWriter w, IPlayerOperation po) {
        this.state = GameState.Stopped;
        players = new ArrayList<Player>();
        events = new ArrayList<GameEvent>();
        writer = w;
        playOp = po;
    }
    public void addPlayer(Player p) {
        if(state != GameState.Stopped) {
            throw new java.lang.Error("You cannot add players during a game.");
        }
        players.add(p);
        numOfPlayers++;
    }
    public void addGameEvent(GameEvent e) {
        events.add(e);
    }
    public GameState getState() {
        return state;
    }
    public void start() {
        state = GameState.Running;
        events.forEach(e -> e.init());
        writer.println(Ansi.ansi().fg(Color.GREEN).a("Welcome to Pig!"));
        writer.println("We have " + numOfPlayers + " fabulous players playing!");
        writer.println("The players playing are");
        for(int i = 0; i < players.size(); i++) {
            writer.println("Player name: " + players.get(i).getPlayerName());
        }
        startNextTurn();
    }
    private boolean endOfCircle() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        return (playerPositionIndex == players.size() - 1);
    }
    public void startNextTurn() {
        turnNumber++;
        if(currentPlayer != null) {
            currentPlayer.setActive(false);
        }
        currentDieSum = 0;
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        if(!endOfCircle()) {
            playerPositionIndex++;
        }
        //Go back in a circle after the last player plays his turn.
        else {
            playerPositionIndex = 0;
        }
        currentPlayer = players.get(playerPositionIndex);
        currentPlayer.setActive(true);
        writer.println(currentPlayer.getPlayerName() + "'s turn.");
        currentPlayer.play(playOp);
    }
    public void currentPlayerRoll() {
        currentPlayer.roll();
        currentDieSum += currentPlayer.getDie1Value() + currentPlayer.getDie2Value();
        currentPlayer.addScore(currentPlayer.getDie1Value() + currentPlayer.getDie2Value());
        writer.println(currentPlayer.getPlayerName() + " rolled. " + currentPlayer.getDie1Value() + ":" + currentPlayer.getDie2Value());
    }
    public void revertChanges() {
        //Make sure to not create a negative score.
        if(currentPlayer.getScore() < currentDieSum) {
            currentPlayer.setScore(0);
        }
        else {
            currentPlayer.decreaseScore(currentDieSum);
        }
    }
    public void checkEvents() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        events.forEach(e -> {
            if(e.shouldBeCalled(this))
            {
                if(!GameEvent.shouldEndTasks()) {
                    e.CallEvent(this);
                }
            }
        });
    }
    public int getCurrentPlayerDiceValue1() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        return currentPlayer.getDie1Value();
    }
    public int getCurrentPlayerDiceValue2() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        return currentPlayer.getDie2Value();
    }
    public int getCurrentPlayerScore() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        return players.get(playerPositionIndex).getScore();
    }
    public int getCurrentPlayerDieSum() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        return currentDieSum;
    }
    public void setCurrentPlayerScore(int score) {
        currentPlayer.setScore(score);
    }
    public Player peakNextPlayer() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        if(!endOfCircle()) {
            return players.get(playerPositionIndex + 1);
        }
        //Go back in a circle after the last player plays his turn.
        else {
            return players.get(0);
        }
    }
    public String getPlayerCurrentName() {
        return players.get(playerPositionIndex).getPlayerName();
    }
    public void setCurrentPlayerAsWinner() {
        if(state != GameState.Running) {
            throw new java.lang.Error("The game must start first.");
        }
        state = GameState.Stopped;
        writer.println(currentPlayer.getPlayerName() + " WON!!!!!!");
        writer.askLine("Press enter to exit...");
        System.exit(0);
    }
    public int getTurnNumber() {
        return turnNumber;
    }
}