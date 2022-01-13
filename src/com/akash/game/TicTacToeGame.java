package com.akash.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class TicTacToeGame extends Game {

    TicTacToeBoard board;
    List<Player> players;
    List<TicTacToeSymbol> symbols;
    private int currentPlayerIndex;

    public TicTacToeGame(TicTacToeBoard board, List<TicTacToeSymbol> symbols, List<Player> players) {
        this.board = board;
        this.symbols = symbols;
        this.players = players;
    }

    @Override
    void initialize() {
        currentPlayerIndex = 0;
        board.initialize();
    }

    @Override
    String getGameTitle() {
        return GameConstants.GAME_TITLE;
    }

    @Override
    void displayGameStats() {
        board.display();
    }

    @Override
    boolean isDraw() {
        return board.isFull();
    }

    @Override
    boolean hasWinner() {
        TicTacToeSymbol symbol = getCurrentPlayerSymbol();
        return board.isRowCaptured(symbol) || board.isColCaptured(symbol) || board.isDiagonalCaptured(symbol);
    }

    @Override
    Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    @Override
    Player getWinningPlayer() {
        return getCurrentPlayer();
    }


    @Override
    void makeMove(Move move) {
        if (!(move instanceof TicTacToeMove))
            return;
        TicTacToeSymbol symbol = getCurrentPlayerSymbol();
        TicTacToeMove m = (TicTacToeMove) move;
        board.set(m.getRow(), m.getCol(), symbol);
    }

    @Override
    PlayerVisibleState getPlayerVisibleState() {
        return new TicTacToePlayerVisibleState(board);
    }

    TicTacToeSymbol getCurrentPlayerSymbol() {
        return symbols.get(currentPlayerIndex);
    }

    @Override
    void updateCurrentPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    @Override
    void getPlayerDetails() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int count = 0;
            String userInput;
            do {
                if (count == 0)
                    System.out.print("Do you want to provide player names (y/n) ? : ");
                else
                    System.out.print("Please provide valid input (y/n) : ");
                userInput = bufferedReader.readLine();
                count++;
            } while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n"));

            if (userInput.equalsIgnoreCase("y")) {
                players.clear();
                for (int i = 1; i <= GameConstants.TOTAL_PLAYERS; i++) {
                    System.out.print("Enter name of Player-" + i + " : ");
                    String name = bufferedReader.readLine();
                    Player player = new HumanPlayer(name);
                    players.add(player);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Sorry something went wrong :(");
        }
    }
}
