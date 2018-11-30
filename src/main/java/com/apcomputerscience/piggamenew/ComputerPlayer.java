package com.apcomputerscience.piggamenew;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ComputerPlayer extends Player {
            
    public ComputerPlayer(String n, IGameWriter w) {
        super(n, w);
    }
    @Override
    public void play(IPlayerOperation op) {
        while(active) {
            try {
                java.lang.Thread.sleep((long)(Math.random() * 1000 * 2));
            } catch (InterruptedException ex) {
                //Do nothing
            }
            if((Math.random() * 5) == 1 && GameEngine.Current.getCurrentPlayerDieSum() > 10) {
                op.stop();
                return;
            }
            op.contueRoll();
        }
    }
}