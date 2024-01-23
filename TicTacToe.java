//-------------------------------------------------------
//Assignment (3)
//Written by: (Wafa Shahid, ID: 40177773)
//For COMP 248 Section (your section) – Summer 2023
//--------------------------------------------------------
package programmingassignment3;

import java.util.Scanner;

public class A3Q2 {
    public static void main(String[] args) {

        // Create a 3x3 array 
        char[][] board = new char[3][3];

        // Initialize our board with dashes 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Welcome Message
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println(" Welcome to Tic-tac-Toe Game  ");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.print("Please enter the names of the two players: ");
        String p1 = scanner.nextLine();
        String p2 = scanner.nextLine();

        // Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
        boolean player1 = true;

        // Create a gameEnded boolean and use it as the condition in the while loop
        boolean gameEnded = false;
        while (!gameEnded) {

            // Draw the board
            drawBoard(board);
            
            
            // Print whose turn it is
            if (player1) {
                System.out.println(p1 + ", please choose a spot.");
            } else {
                System.out.println(p2 + "', please choose a spot.");
            }

            // Create a char variable that stores either 'X' or 'O' based on what player's turn it is
            char c = '-';
            if (player1) {
                c = 'X';
            } else {
                c = 'O';
            }

            // Create row and column variables which represent indexes that correspond to a position on our board
            int row = 0;
            int col = 0;

            // Only break out of the while loop once the user enters a valid position
            while (true) {

                // Ask the user for what position they want to place their X or O
                System.out.print("Please choose a spot (row, col): ");
                String spotInput = scanner.nextLine();
                String[] spot = spotInput.split(",");
                row = Integer.parseInt(spot[0].trim());
                col = Integer.parseInt(spot[1].trim());

                // Check if the row and col are 0, 1, or 2
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Invalid spot. Row and column numbers can not exceed 2.");
                    continue;
                }

                // Check if the position on the board the user entered is empty (has a -) or not
                if (board[row][col] != '-') {
                    System.out.println("Spot has already been taken.");
                    continue;
                }

                // Otherwise, the position is valid so break out of the while loop
                break;

            }

            // Set the position on the board at row, col to c
            board[row][col] = c;

            // Check to see if either player has won
            if (playerHasWon(board) == 'X') {
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if (playerHasWon(board) == 'O') {
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {

                // If neither player has won, check to see if there has been a tie (if the board is full)
                if (boardIsFull(board)) {
                    System.out.println("The game ends in a draw!");
                    gameEnded = true;
                } else {
                    // If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                    player1 = !player1;
                }

            }

        }

        // Draw the board at the end of the game
        drawBoard(board);
        
        // Closing message
        System.out.println("Thank you for playing the Tic-Tac-Toe game !!!");


    }

    // Drawing the tic tac toe board
    public static void drawBoard(char[][] board) {
        System.out.println("Current state of the board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    System.out.print("___ ");
                } else {
                    System.out.print(board[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    // Make a function to see if someone has won and return the winning character (X or O)
    public static char playerHasWon(char[][] board) {

        // Check each row
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        // Check each column
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        // Check the diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        // Otherwise, nobody has won yet
        return ' ';

    }

    // Make a function to check if all of the positions on the board have been filled
    public static boolean boardIsFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
        
    }   
}
