package com.example.labee.thirdLab.model.core;

import lombok.Getter;

import java.util.Random;

@Getter
public class TicTacToeGame {
    private final char[][] board;
    private boolean playerTurn;
    private boolean gameOver;

    public TicTacToeGame() {
        board = new char[3][3];
        playerTurn = true;
        gameOver = false;
    }

    public boolean isPlayerWinner() {
        return checkWinner('X');
    }

    public boolean isComputerWinner() {
        return checkWinner('O');
    }

    public void makePlayerMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = 'X';
            playerTurn = false;
            if (!isGameOver()) {
                makeComputerMove();
            }
        }
    }

    private void makeComputerMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));
        board[row][col] = 'O';
        playerTurn = true;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '\0';
    }

    public boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i, player) || checkColumn(i, player)) {
                gameOver = true;
                return true;
            }
        }
        if (checkDiagonal(player) || checkAntiDiagonal(player)) {
            gameOver = true;
            return true;
        }
        if (isBoardFull()) {
            gameOver = true;
        }
        return false;
    }

    private boolean checkRow(int row, char player) {
        return board[row][0] == player && board[row][1] == player && board[row][2] == player;
    }

    private boolean checkColumn(int col, char player) {
        return board[0][col] == player && board[1][col] == player && board[2][col] == player;
    }

    private boolean checkDiagonal(char player) {
        return board[0][0] == player && board[1][1] == player && board[2][2] == player;
    }

    private boolean checkAntiDiagonal(char player) {
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }
}
