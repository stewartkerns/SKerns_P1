
package SKerns_P1;

public class TicTacToe {
    private int boardSize;
    private int[][] board;
    private final int PLAYER_VAL_1 = 1;
    private final int PLAYER_VAL_2 = -1;
    private boolean spaceClear;
    private int count;


    public TicTacToe(){
        this.boardSize = 3;
        this.board = new int[boardSize][boardSize];
//        int[][] testMatrix = new int[3][3];
//        for (int i = 0; i < 3; i++){
//            this.board[i][0] = -1;
//        }
    }
    public void pieceOnBoard(int row, int column, int userVal){
        incrementCount();
        board[row][column] = userVal;
            //These inputs need to be validated
    }

    public boolean checkPieceOnBoard(int row, int column) {
        if (board[row][column] == 0) {
            //need to implement piece on board here and pob private
            return true;
        } else {
            return false;
        }
    }
    public void printBoard(){
        int numDash = boardSize * 4;
        int boardLength = boardSize + (boardSize);
        int countRow = 0;
        for (int i = 0; i < boardLength; i++){
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
    public int checkRowsAndCol(){
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
//            if (sumRow == (boardSize * userVal1) || sumRow == (boardSize *
//                    userVal2)) {
//                return (sumRow / boardSize);
            }
            else if (checkSum(sumCol)){
                return sumCol / boardSize;
            }
        }
        return 0;
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

        return 0;
    }
    private boolean checkSum(int sum){
        if (sum == (boardSize * PLAYER_VAL_1) || sum == (boardSize *
                PLAYER_VAL_2)) {
            return true;
        }
        return false;
    }
    public void congratulateWinner(int winner,
                                          final String PLAYER_1_NAME,
                                          final String PLAYER_2_NAME) {
        String congrats = ", congrats!  You are the winner!  Here is the " +
                "final board:";
        switch (winner) {
            case PLAYER_VAL_1: {
                System.out.println("\n" + PLAYER_1_NAME + congrats);
                break;
            }
            case PLAYER_VAL_2: {
                System.out.println("\n" + PLAYER_2_NAME + congrats);
                break;
            }
        }
    }

    private void incrementCount(){
        count++;
    }

    public int getCount(){
        return count;
    }
    public int getBoardSize(){
        return boardSize;
    }
}
