package com.akash.game;

public abstract class Game {
    abstract String getGameTitle();

    abstract void initialize();

    abstract void displayGameStats();

    abstract boolean isDraw();

    abstract boolean hasWinner();

    abstract Player getCurrentPlayer();

    abstract Player getWinningPlayer();

    abstract void makeMove(Move move);

    abstract PlayerVisibleState getPlayerVisibleState();

    abstract void updateCurrentPlayer();

    abstract void getPlayerDetails();

    void play() {
        System.out.println("Playing " + getGameTitle());
        getPlayerDetails();
        initialize();
        do {
            updateCurrentPlayer();
            Player currentPlayer = getCurrentPlayer();
            PlayerVisibleState state = getPlayerVisibleState();
            Move move = currentPlayer.getMove(state);
            makeMove(move);

        } while (!isDraw() && !hasWinner());
        displayGameStats();
        if (isDraw()) {
            System.out.println("Game is draw :(");
        } else if (hasWinner()) {
            Player winner = getWinningPlayer();
            System.out.println(winner.getName() + " has won the game :)");
        }


    }

    ;
}
