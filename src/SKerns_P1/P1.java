/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package SKerns_P1;

import java.util.Scanner;   //import the Scanner class

/**
 * This program gives the user a welcome message, plays a tic-tac-toe game
 * until the player no longer wants to and then provides a goodbye message
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class P1 {

    /**
     * The main method calls the welcome method, calls the playGame method from
     * the TicTacToe class, allows the user to play as many times as they want
     * and then calls a goodbye message
     *
     * @param args a String array containing the command line arguments
     */
    public static void main(String[] args){
        //create a new TicTacToe object
        TicTacToe game = new TicTacToe();
        //Create a new Scanner object to read user input
        Scanner keyboardIn = new Scanner(System.in);
        //Prints a welcome message
        welcome();
        //Allow the user to play the game as many times as they want
        do {
            //play the game
            game.playGame(keyboardIn);
        } while(!noPlay(keyboardIn));
        //print a goodbye message
        goodbye();
        //close the scanner object
        keyboardIn.close();
    }

    /**
     * This method prints a welcome message to the user
     */
    public static void welcome(){
        System.out.println("Welcome to the P1 program, this program will " +
                "allow two users to play\na game of Tic-Tac-Toe for as many" +
                "rounds as they would like.\nPlayer X will go first and it " +
                "will alternate from there.\n");
    }

    /**
     * This method prints a goodbye message to the user
     */
    public static void goodbye(){
        System.out.println("Thanks for playing!");
    }
//    public void playGame(Scanner keyboardIn){
//
//        int checkWin;
//        final int NO_WINNER = 0;
//        int MAX_TURNS = (int)Math.pow(game.getBoardSize(), 2);
//
//        do {
//            game.userTurn(keyboardIn, game.getPLAYER_1_NAME(),
//                    game.getPLAYER_VAL_1());
//            checkWin = game.checkWinner();
//            if (game.getCount() < MAX_TURNS && checkWin == NO_WINNER){
//                game.userTurn(keyboardIn, game.getPLAYER_2_NAME(),
//                        game.getPLAYER_VAL_2());
//                checkWin = game.checkWinner();
//            }
//
//        } while(game.getCount() < MAX_TURNS && checkWin == NO_WINNER);
////        return checkWin;
//
//        game.congratulateWinner(checkWin);
//        game.printWinnerStats();
//        game.clearBoard();
//        keyboardIn.close();
//    }

    /**
     * This method asks the user if they want to continue playing and requests
     * them to enter "no" if they no longer want to play
     * @param keyboardIn A scanner object to take in user input from the
     *                   keyboard
     * @return boolean value of if the user wants to continue
     */
    public static boolean noPlay(Scanner keyboardIn){
        //create a final String to match the user input to
        final String stringEnd = "NO";

        //prompt the user on if they want to play again
        System.out.print("\nWould you like to play again? (no to quit): ");
        //absorb the leftover \n from int inputs
        keyboardIn.nextLine();
        //take in the user input and assign it to a String
        String userAnswer = keyboardIn.nextLine();

        //return true if the string input by the user matches
        return userAnswer.equalsIgnoreCase(stringEnd);
    }

//    public static int checkWinner(TicTacToe game){
//        int rowsAndColumns = game.checkRowsAndCol();
//        if (rowsAndColumns != 0){
//            return rowsAndColumns;
//        }
//        else{
//            return game.checkDiags();
//        }
//    }
//    public static void userTurn(Scanner keyboardIn, TicTacToe game,
//                                final String PLAYER_NAME, final int USER_VAL){
//        game.printBoard();
//        int[] userChoice;
//        do {
//            userChoice = userChoose(keyboardIn, PLAYER_NAME);
//            } while (!game.checkPieceOnBoard(userChoice[0],
//                    userChoice[1]));
//        game.pieceOnBoard(userChoice[0], userChoice[1], USER_VAL);
//
//    }
//    public static int[] userChoose(Scanner keyboardIn, String player) {
//        int[] userChoice = new int[2];
//        final int ROW = 0;
//        final int COL = 1;
//        System.out.print("\nChoose a free space on the board " + player +
//                ".\nThis will be input with a row and column seperated by a" +
//                " space: ");
//        userChoice[ROW] = keyboardIn.nextInt();
//        userChoice[COL] = keyboardIn.nextInt();
//        return userChoice;
//
//    }
}
