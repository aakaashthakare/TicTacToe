package com.akash.game;

public class Main {

    public static void main(String[] args) {
        Game game = TicTacToeFactory.twoPlayerStandard3x3Game();
        game.play();
    }
}
