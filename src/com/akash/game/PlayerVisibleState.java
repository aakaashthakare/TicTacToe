package com.akash.game;

public interface PlayerVisibleState {
    void display();

    Pair<Integer, Integer> getFirstEmptyLocation();

    public TicTacToeBoard getBoard();
}
