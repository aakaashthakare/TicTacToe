package com.akash.game;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer implements Player{
    private final String name;
    private BufferedReader br;

    public HumanPlayer(String name) {
        this.name = name;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public Move getMove(PlayerVisibleState state) {

        state.display();
        try{
            System.out.print(name + ": Please enter cell number (1-9) :");
           int cell = Integer.parseInt(br.readLine());
           cell = cell -1 ;
           return new TicTacToeMove(cell/3, cell%3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
