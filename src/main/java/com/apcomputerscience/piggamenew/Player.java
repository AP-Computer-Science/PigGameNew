package com.apcomputerscience.piggamenew;

public class Player {
    private IGameWriter writer;
    private PairOfDice dice;
    private int score;
    private final String name;
    protected boolean active;
    public Player(String n, IGameWriter w) {
        name = n;
        writer = w;
        dice = new PairOfDice();
    }
    public String getPlayerName() {
        return name;
    }
    public void roll() {
        dice.roll();
    }
    public int getDie1Value() {
        return dice.getDie1Face();
    }
    public int getDie2Value() {
        return dice.getDie2Face();
    }
    public int getScore() {
        return score;
    }
    public PairOfDice getDice() {
        return dice;
    }
    public void setScore(int s) {
        score = s;
    }
    public void addScore(int s) {
        score += s;
    }
    public void setActive(boolean a) {
        active = a;
    }
    public void play(IPlayerOperation po) {
        while(active) {
            char answer = writer.askWord("Roll [Y/N]? ")
                        .toUpperCase()
                        .charAt(0);
            if(answer == 'Y') {
                po.contueRoll();
            }
            else {
                po.stop();
            }
        }
    }
}