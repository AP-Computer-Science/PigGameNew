package com.apcomputerscience.piggamenew;

import com.apcomputerscience.piggamenew.events.WinConditionEvent;
import com.apcomputerscience.piggamenew.events.SumReduceEvent;
import com.apcomputerscience.piggamenew.events.OneEvent;
import com.apcomputerscience.piggamenew.events.SnakeEyeEvent;
import com.apcomputerscience.piggamenew.events.DoubleSixEvent;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;

public class PigGameMain {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        IGameWriter writer = new ConsoleGameWriter();
        String name = writer.askLine("What is your name, human? ");
        String computerName = writer.askLine("What is the computer's name? ");
        GameEngine.Current = new GameEngine(writer, new StandordPlayerOperations(writer));
        GameEngine.Current.addPlayer(new ComputerPlayer(name, writer));
        GameEngine.Current.addPlayer(new ComputerPlayer(computerName, writer));
        GameEngine.Current.addPlayer(new ComputerPlayer("Sam Tupy", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Dave Johnson", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Old Joe", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Steven Wonders", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Mario Mario", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Ronald Reagon", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Dracula", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Dora", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Superman", writer));
        //GameEngine.Current.addPlayer(new ComputerPlayer("Odysseus", writer));
        //GameEngine.Current.addGameEvent(new DoubleSixEvent(writer));
        GameEngine.Current.addGameEvent(new SnakeEyeEvent(writer));
        GameEngine.Current.addGameEvent(new OneEvent(writer));
        GameEngine.Current.addGameEvent(new SumReduceEvent(writer, 20));
        GameEngine.Current.addGameEvent(new WinConditionEvent(writer, 100));
        GameEngine.Current.start();
        while(GameEngine.Current.getState() == GameState.Running) {
            GameEngine.Current.startNextTurn();
        }
    }   
}