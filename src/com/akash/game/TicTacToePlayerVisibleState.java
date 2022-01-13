package com.akash.game;

public class TicTacToePlayerVisibleState implements PlayerVisibleState{
    private TicTacToeBoard ticTacToeBoard;

    public TicTacToePlayerVisibleState(TicTacToeBoard board){
        this.ticTacToeBoard= board;
    }
    public void display(){
        ticTacToeBoard.display();
    }

    public TicTacToeBoard  getBoard(){
        return this.ticTacToeBoard;
    }


    @Override
    public Pair<Integer, Integer> getFirstEmptyLocation() {
        return ticTacToeBoard.firstEmptyLocation();
    }


}
