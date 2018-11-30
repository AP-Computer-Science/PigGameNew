package com.apcomputerscience.piggamenew;

public class PairOfDice {
    private Die die1;
    private Die die2;
    public PairOfDice(Die d1, Die d2) {
        die1 = d1;
        die2 = d2;
    }
    public PairOfDice() {
        die1 = new Die(6);
        die2 = new Die(6);
    }
    public void roll() {
        die1.roll();
        die2.roll();
    }
    public int getDie1Face() {
        return die1.getFace();
    }
    public int getDie2Face() {
        return die2.getFace();
    }
    public int getTotal() {
        return die1.getFace() + die2.getFace();
    }
    public String toString() {
        String result = "Die 1: " + die1 + "\n";
        result += "Die 2: " + die2 + "\n";
        return result;
    }
}