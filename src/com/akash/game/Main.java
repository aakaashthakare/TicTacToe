package com.akash.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game game = TicTacToeFactory.twoPlayerStandard3x3Game(); ;
        System.out.println("Welcome to the best tic-tac-toe game in the world !! ");
        System.out.print("Select Game Type :\n1.Human VS Human\n2.Human VS Bot\nPlease Enter 1 OR 2 : ");
        try {
            int type = Integer.parseInt(br.readLine());
            if(type == 1)
                 game = TicTacToeFactory.twoPlayerStandard3x3Game();
            if(type == 2)
                game = TicTacToeFactory.singlePlayerStandard3x3Game();
            game.play();
        }catch (Exception e){
            System.out.println("\nSorry something went wrong........ :(");
        }


    }
}
