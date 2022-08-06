/*
 * Stewart Kerns
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package SKerns_P1;

import java.util.Scanner;   //import the Scanner class

/**
 * This class builds all the fields and methods needed to create a game of
 * tic-tac-toe to be played by 2 users on a board of 3 rows/columns
 *
 * @author Stewart Kerns
 * @version 1.0
 */
public class TicTacToe {
    private int boardSize;
    private int[][] board;
    private final String PLAYER_1_NAME = "Player X";
    private final String PLAYER_2_NAME = "Player O";
    private final int PLAYER_VAL_1 = 1;
    private final int PLAYER_VAL_2 = -1;
    private final int ROW = 0;
    private final int COL = 1;
    private final int NO_WINNER = 0;
    private int count;
    private final int NUM_PLAYERS = 2;
    private final int NUM_DIMENSIONS = 2;

    private int[] winnerStats;
    private int[] userChoice;

    public TicTacToe(){
        this.boardSize = 3;
        this.board = new int[boardSize][boardSize];
        this.userChoice = new int[NUM_DIMENSIONS];
        this.winnerStats = new int[NUM_PLAYERS];

//        int[][] testMatrix = new int[3][3];
//        for (int i = 0; i < 3; i++){
//            this.board[i][0] = -1;
//        }
    }

    public void playGame(Scanner keyboardIn){

        int checkWin;
        int MAX_TURNS = (int)Math.pow(boardSize, 2);

        do {
            userTurn(keyboardIn, PLAYER_1_NAME,
                    PLAYER_VAL_1);
            checkWin = checkWinner();
            if (count < MAX_TURNS && checkWin == NO_WINNER){
                userTurn(keyboardIn, PLAYER_2_NAME,
                        PLAYER_VAL_2);
                checkWin = checkWinner();
            }

        } while(count < MAX_TURNS && checkWin == NO_WINNER);
//        return checkWin;

        congratulateWinner(checkWin);
        printWinnerStats();
        clearBoard();
    }
    private void pieceOnBoard(int row, int column, int userVal){
        incrementCount();
        board[row][column] = userVal;
    }

    public boolean checkPieceOnBoard(int row, int column) {
        return board[row][column] == 0;
    }

    public int checkWinner(){
        int rowsAndColumns = checkBoardStraights();
        if (rowsAndColumns != NO_WINNER){
            return rowsAndColumns;
        }
        else{
            return checkDiags();
        }
    }

    public void userTurn(Scanner keyboardIn,
                                final String PLAYER_NAME, final int USER_VAL){
        printBoard();
//        int[] userChoice;
        do {
//            userChoice =
            userChoose(keyboardIn, PLAYER_NAME);
        } while (!checkPieceOnBoard(userChoice[ROW],
                userChoice[COL]));
        pieceOnBoard(userChoice[ROW], userChoice[COL], USER_VAL);

    }
    public void userChoose(Scanner keyboardIn, String player) {
//        int[] userChoice = new int[2];
        System.out.println("\nChoose a free space on the board " + player +
                ".");
        do {
            System.out.print("Please choose a valid row: ");
            userChoice[ROW] = keyboardIn.nextInt();
        } while (userChoice[ROW] >= boardSize || userChoice[ROW] < 0);

        do {
            System.out.print("Please choose a valid column: ");
            userChoice[COL] = keyboardIn.nextInt();
        } while (userChoice[COL] >= boardSize || userChoice[COL] < 0);
    }

    public void printBoard(){
        final int NUM_SPACES = 4;
        final int NUM_ROWS_PER_ROW = 2;
        int numDash = boardSize * NUM_SPACES;
        int printBoardLength = boardSize * NUM_ROWS_PER_ROW;
        int countRow = 0;
        System.out.print("  ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print(" " + i + "  ");
        }
        for (int i = 0; i < printBoardLength; i++){
            System.out.println();

            if (i % 2 != 0) {
                for (int d = 0; d < numDash; d++) {
                    if (d == 0) {
                        System.out.print("  ");
                    }
                    System.out.print("-");
                }
            }
            else{
                for (int j = 0; j < boardSize; j++) {

                    if (j == 0) {
                        System.out.printf("%2d", countRow);
                    }
                    if (board[countRow][j] == 0) {
                        System.out.print("   |");
                    }
                    else{
                        switch (board[countRow][j]) {
                            case 1: {
                                System.out.print(" X |");
                                break;
                            }
                            case -1: {
                                System.out.print(" O |");
                                break;
                            }
                        }
                    }

                }
                countRow++;
            }
        }
    }
    public int checkBoardStraights(){
        //declare a sum to check against
        int sumRow;
        int sumCol;
        for (int i = 0; i < boardSize; i++){
            sumRow = 0;
            sumCol = 0;
            for (int j = 0; j < boardSize; j++){
                sumRow += board[i][j];
                sumCol += board[j][i];
            }
            if (checkSum(sumRow)){
                return sumRow / boardSize;
            }
            else if (checkSum(sumCol)){
                return sumCol / boardSize;
            }
        }
        return NO_WINNER;
    }

//    public int checkColumns(){
//        int sumCol;
//        for (int j = 0; j < boardSize; j++){
//            sumCol = 0;
//            for (int i = 0; i < boardSize; i++){
//                sumCol += board[i][j];
//            }
//            if (checkSum(sumCol)){
//                return sumCol / boardSize;
//            }
//        }
//        return 0;
//    }

    public int checkDiags(){
        int sumDiag = 0;
        int sumDiag2 = 0;
        //check the first diagonal
        for (int i = 0; i < boardSize; i++){
            sumDiag += board[i][i];
            }
        if (checkSum(sumDiag)){
            return sumDiag / boardSize;
        }

        //check the second diagonal
        for (int i = 0; i < boardSize; i++){
            sumDiag2 += board[(boardSize - 1) - i][i];
        }
        if (checkSum(sumDiag2)){
            return sumDiag2 / boardSize;
        }

        return NO_WINNER;
    }
    private boolean checkSum(int sum){
        if (sum == (boardSize * PLAYER_VAL_1) || sum == (boardSize *
                PLAYER_VAL_2)) {
            return true;
        }
        return false;
    }
    public void congratulateWinner(int winner) {
        String congrats = ", congrats!  You are the winner!  Here is the " +
                "final board:";
        switch (winner) {
            case PLAYER_VAL_1: {
                System.out.println("\n" + PLAYER_1_NAME + congrats);
                winnerStats[0]++;
                break;
            }
            case PLAYER_VAL_2: {
                System.out.println("\n" + PLAYER_2_NAME + congrats);
                winnerStats[1]++;
                break;
            }
            case NO_WINNER:
                System.out.println("\nNo one wins!  It's a tie! Here is the " +
                        "final board: ");
                break;
        }
        printBoard();

    }
    public void printWinnerStats(){
        System.out.println("\n" + PLAYER_1_NAME + " has won " + winnerStats[0] +
                " times!");
        System.out.println(PLAYER_2_NAME + " has won " + winnerStats[1] +
                " times!");
    }
    public void clearBoard(){
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board[i][j] = 0;
            }
        }
        count = 0;
    }

    private void incrementCount(){
        count++;
    }

//    public int getCount(){
//        return count;
//    }
//    public int getBoardSize(){
//        return boardSize;
//    }
//    public String getPlayer1Name(){
//        return PLAYER_1_NAME;
//    }
//
//    public String getPlayer2Name(){
//        return PLAYER_2_NAME;
//    }
//
//    public int getPlayerVal1(){
//        return PLAYER_VAL_1;
//    }
//
//    public int getPlayerVal2(){
//        return PLAYER_VAL_2;
//    }
}
