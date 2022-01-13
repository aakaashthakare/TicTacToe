package com.akash.game;

public class Main {

    public static void main(String[] args) {
        // Builder Patter : helps us to create complex object - objects with
        // Factory Pattern : provide default configuration
        // Template Patter : Boilerplate code to perform some action

        Game game = TicTacToeFactory.standard3x3Game();
        game.play();

    }
}
