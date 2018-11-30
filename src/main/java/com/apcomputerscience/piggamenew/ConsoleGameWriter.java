package com.apcomputerscience.piggamenew;

import java.util.Scanner;

public class ConsoleGameWriter implements IGameWriter {
    Scanner scan = new Scanner(System.in);
    @Override
    public void print(Object write) {
        System.out.print(write);
    }

    @Override
    public void println(Object write) {
        System.out.println(write);
    }

    @Override
    public String askWord(String question) {
        System.out.print(question);
        return scan.next();
    }

    @Override
    public String askLine(String question) {
        System.out.print(question);
        return scan.nextLine();
    }

    @Override
    public char askChar(String question) {
        System.out.print(question);
        return scan.next().charAt(0);
    }

    @Override
    public void println() {
        System.out.println();
    }
}