
package SKerns_P1;

import java.util.Scanner;
public class P1 {

    public static void main(String[] args){
    TicTacToe game = new TicTacToe();
    Scanner keyboardIn = new Scanner(System.in);
//    int[][] testMatrix = new int[3][3];
//    for (int i = 0; i < 3; i++){
//        testMatrix[i][0] = 1;
//    }
//        game.printBoard();
//        System.out.println("\n" + game.checkRowsAndCol());
//        System.out.println((game.checkDiags()));
        playGame(keyboardIn, game);

    }
//    public static void announceWinner(int winner){
//
//        if winner
//    }
    public static void playGame(Scanner keyboardIn, TicTacToe game){
        final int NUM_PLAYERS = 2;
        final String PLAYER_1_NAME = "Player X";
        final String PLAYER_2_NAME = "Player O";
        final int PLAYER_1_VAL = 1;
        final int PLAYER_2_VAL = -1;
        int count = 0;
        int checkWin;
        final int SQUARED = 2;
        final int NO_WINNER = 0;
        int MAX_TURNS = (int)Math.pow(game.getBoardSize(), SQUARED);
        int[] userChoice1 = new int[NUM_PLAYERS];
        int[] userChoice2 = new int[NUM_PLAYERS];
        do {
            userTurn(keyboardIn, game, PLAYER_1_NAME, PLAYER_1_VAL);
            checkWin = checkWinner(game);
            if (game.getCount() < MAX_TURNS && checkWin == NO_WINNER){
                userTurn(keyboardIn, game, PLAYER_2_NAME, PLAYER_2_VAL);
            }
            checkWin = checkWinner(game);

        } while(game.getCount() < MAX_TURNS && checkWin == NO_WINNER);
//        return checkWin;

        game.congratulateWinner(checkWin, PLAYER_1_NAME, PLAYER_2_NAME);
        game.printBoard();
    }

    public static int checkWinner(TicTacToe game){
        int rowsAndColumns = game.checkRowsAndCol();
        if (rowsAndColumns != 0){
            return rowsAndColumns;
        }
        else{
            return game.checkDiags();
        }
    }
    public static void userTurn(Scanner keyboardIn, TicTacToe game,
                                final String PLAYER_NAME, final int USER_VAL){
        game.printBoard();
        int[] userChoice;
        do {
            userChoice = userChoose(keyboardIn, PLAYER_NAME);
            } while (!game.checkPieceOnBoard(userChoice[0],
                    userChoice[1]));
        game.pieceOnBoard(userChoice[0], userChoice[1], USER_VAL);

    }
    public static int[] userChoose(Scanner keyboardIn, String player) {
        int[] userChoice = new int[2];
        final int ROW = 0;
        final int COL = 1;
        System.out.print("\nChoose a free space on the board " + player +
                ".\nThis will be input with a row and column seperated by a" +
                " space: ");
        userChoice[ROW] = keyboardIn.nextInt();
        userChoice[COL] = keyboardIn.nextInt();
        return userChoice;

    }
}
