package com.akash.game;

public abstract class Game {
    abstract String getGameTitle();
    abstract void initialize();
    abstract void displayGameStats();
    abstract boolean isDraw();
    abstract boolean hasWinner();
    abstract Player getCurrentPlayer();
    abstract Player getWinningPlayer();
    abstract boolean makeMove();
    abstract void makeMove(Move move);
    abstract PlayerVisibleState getPlayerVisibleState(Player player);
    // chess / snakes and ladder / tic-tac-toe
    // battleship / cards / scrabble

    void play (){
        System.out.println("PLAYING A GAME OF " + getGameTitle());
        initialize();
        do {
            displayGameStats();
            Player currentPlayer = getCurrentPlayer();
            PlayerVisibleState state = getPlayerVisibleState(currentPlayer);
            Move move = currentPlayer.makeMove(state);
            makeMove(move);

        } while(!isDraw() && !hasWinner());

        if(isDraw()){
            System.out.println("Game is draw :(");
        }
        else if(hasWinner()){
            Player winner = getWinningPlayer();
            System.out.println(winner.getName() + " has won the game :)");
        }


    };
}
