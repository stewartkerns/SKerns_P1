
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
        game.printBoard();
        System.out.println("\n" + game.checkRowsAndCol());
        System.out.println((game.checkDiags()));
//    playGame(keyboardIn, game);

    }

    public static void playGame(Scanner keyboardIn, TicTacToe game){
        final int NUM_PLAYERS = 2;
        final String PLAYER_1_NAME = "Player 1";
        final String PLAYER_2_NAME = "Player 2";
        final int USER_1_VAL = 1;
        final int USER_2_VAL = -1;
        int count = 0;
        int checkWin;
        int MAX_TURNS = (int)Math.pow(game.getBoardSize(), 2);
        int[] userChoice1 = new int[NUM_PLAYERS];
        int[] userChoice2 = new int[NUM_PLAYERS];
        do {
            userTurn(keyboardIn, game, PLAYER_1_NAME, USER_1_VAL);
            count++;
            checkWin = checkWinner(game);
            if (count < MAX_TURNS && checkWin == 0){
                userTurn(keyboardIn, game, PLAYER_2_NAME, USER_2_VAL);
                count++;
            }
            checkWin = checkWinner(game);

        } while(count < MAX_TURNS || checkWin == 0);
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
