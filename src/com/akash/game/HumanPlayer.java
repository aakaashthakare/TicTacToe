package com.akash.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Human Player
public class HumanPlayer implements Player {
    private String name;
    private BufferedReader br;


    public HumanPlayer() {

    }

    public HumanPlayer(String name) {
        this.name = name;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public Move getMove(PlayerVisibleState state) {
        TicTacToeBoard board = state.getBoard();
        state.display();
        try {
            int cell;
            boolean notMarked = true, validCell = true;
            do {
                if (!notMarked)
                    System.out.print("Sorry " + name + " cell already marked, try another : ");
                else if (!validCell)
                    System.out.print(name + ", please enter valid cell number (1-9) : ");
                else
                    System.out.print(name + ", enter cell number (1-9) : ");
                cell = Integer.parseInt(br.readLine());
                validCell = (cell >= 1 && cell <= 9) ? true : false;
                if (!validCell) continue;
                if (board.markCellFilled(cell)) {
                    cell = cell - 1;
                    return new TicTacToeMove(cell / 3, cell % 3);
                }

                notMarked = board.markCellFilled(cell);
            } while (!validCell || !notMarked);
        } catch (Exception e) {
            System.out.println("Sorry something went wrong :(");
        }
        return null;
    }
}
