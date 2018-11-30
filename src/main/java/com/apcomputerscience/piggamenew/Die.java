package com.apcomputerscience.piggamenew;

public class Die {
    private int sides;
    private int face;
    public Die() {
        sides = 6;
        roll();
    }
    public Die(int s) {
        sides = s;
        roll();
    }
    public void roll() {
        int randVal = (int)(Math.random() * sides + 1);
        face = randVal;
    }
    public int getFace() {
        return face;
    }
    @Override
    public String toString() {
        return String.valueOf(getFace());
    }
}