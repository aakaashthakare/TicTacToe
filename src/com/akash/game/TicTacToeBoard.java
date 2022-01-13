package com.akash.game;


import java.util.HashSet;

public class TicTacToeBoard {
    TicTacToeSymbol[][] board;
    int numRows, numCols;
    HashSet<Integer> cells = new HashSet<>();

    public TicTacToeBoard(int numRows, int numCols) {
        this.numCols = numCols;
        this.numRows = numRows;
        board = new TicTacToeSymbol[numRows][numCols];
    }

    public void initialize() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                board[row][col] = null;
            }
        }
    }


    boolean markCellFilled(int cell) {
        return cells.add(cell);
    }


    public void display() {
        System.out.println("Tic-Tac-Toe Board :\n");

        for (int row = 0; row < numRows; row++) {
            if (row != 0)
                System.out.println("---+---+---");
            if (board[row][0] != null)
                System.out.print(" " + board[row][0].toString() + " ");
            else
                System.out.print("   ");
            for (int col = 1; col < numCols; col++) {
                if (board[row][col] != null)
                    System.out.print("| " + board[row][col].toString() + " ");
                else
                    System.out.print("|   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isFull() {
        for (int row = 0; row < numRows; row++)
            for (int col = 1; col < numCols; col++)
                if (board[row][col] == null)
                    return false;
        return true;
    }

    boolean isRowCaptured(TicTacToeSymbol symbol) {
        for (int row = 0; row < numRows; row++) {
            boolean rowOccupied = true;
            for (int col = 0; col < numCols; col++) {
                if (!symbol.equals(board[row][col])) {
                    rowOccupied = false;
                    break;
                }
            }
            if (rowOccupied)
                return true;
        }
        return false;
    }

    boolean isColCaptured(TicTacToeSymbol symbol) {
        for (int col = 0; col < numCols; col++) {
            boolean colOccupied = true;
            for (int row = 0; row < numRows; row++) {
                if (!symbol.equals(board[row][col])) {
                    colOccupied = false;
                    break;
                }
            }
            if (colOccupied)
                return true;
        }
        return false;
    }

    boolean isDiagonalCaptured(TicTacToeSymbol symbol) {
        boolean diagonalOccupied = true;
        for (int row = 0; row < numRows; row++) {
            if (!symbol.equals(board[row][row])) {
                diagonalOccupied = false;
                break;
            }

        }

        if (diagonalOccupied)
            return true;

        // Check anti-diagonal
        diagonalOccupied = true;
        for (int row = 0; row < numRows; row++) {
            if (!symbol.equals(board[row][(numRows - 1) - row])) {
                diagonalOccupied = false;
                break;
            }

        }

        if (diagonalOccupied)
            return true;

        return false;
    }

    public void set(int row, int col, TicTacToeSymbol symbol) {
        board[row][col] = symbol;
    }

    public Pair<Integer, Integer> firstEmptyLocation() {
        for (int row = 0; row < numRows; row++)
            for (int col = 0; col < numCols; col++)
                if (board[row][col] == null)
                    return new Pair<>(row, col);
        return null;
    }


}
