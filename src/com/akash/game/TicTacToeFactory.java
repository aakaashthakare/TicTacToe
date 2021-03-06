package com.akash.game;

import java.util.Arrays;

public class TicTacToeFactory {
    public static Game twoPlayerStandard3x3Game() {
        TicTacToeSymbol cross = new TicTacToeSymbol("X");
        TicTacToeSymbol nought = new TicTacToeSymbol("O");
        TicTacToeBoard board = new TicTacToeBoard(3, 3);
        Player player1 = new HumanPlayer("Dumpty");
        Player player2 = new HumanPlayer("Humpty");
        return new TicTacToeGame(board, Arrays.asList(cross, nought), Arrays.asList(player1, player2));
    }

    public static Game singlePlayerStandard3x3Game() {
        TicTacToeSymbol cross = new TicTacToeSymbol("X");
        TicTacToeSymbol nought = new TicTacToeSymbol("O");
        TicTacToeBoard board = new TicTacToeBoard(3, 3);
        Player player1 =  new DumbAIPlayer();
        Player player2 = new HumanPlayer("Human");
        return new TicTacToeGame(board, Arrays.asList(cross, nought), Arrays.asList(player1, player2));
    }
}
