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
    abstract PlayerVisibleState getPlayerVisibleState(Player player);
    abstract void updateCurrentPlayer();
    // chess / snakes and ladder / tic-tac-toe
    // battleship / cards / scrabble

    void play (){
        System.out.println("Playing " + getGameTitle());
        initialize();
        do {
            updateCurrentPlayer();
//            displayGameStats();
            Player currentPlayer = getCurrentPlayer();
            PlayerVisibleState state = getPlayerVisibleState(currentPlayer);
            Move move = currentPlayer.getMove(state);
            makeMove(move);

        } while(!isDraw() && !hasWinner());
        displayGameStats();
        if(isDraw()){
            System.out.println("Game is draw :(");
        }
        else if(hasWinner()){
            Player winner = getWinningPlayer();
            System.out.println(winner.getName() + " has won the game :)");
        }


    };
}
