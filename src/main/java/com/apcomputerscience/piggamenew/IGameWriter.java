package com.apcomputerscience.piggamenew;

public interface IGameWriter {
    void print(Object write);
    void println(Object write);
    void println();
    String askWord(String question);
    String askLine(String question);
    char askChar(String question);
}