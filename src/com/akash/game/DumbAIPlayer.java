package com.akash.game;

public class DumbAIPlayer implements Player{
    @Override
    public String getName() {
        return "Dumb AI";
    }

    @Override
    public Move getMove(PlayerVisibleState state) {
        Pair<Integer,Integer> cell = state.getFirstEmptyLocation();
        return new TicTacToeMove(cell.first,cell.second);
    }

    @Override
    public void setName(String name) {

    }
}
