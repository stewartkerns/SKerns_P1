
package SKerns_P1;

public class TicTacToe {
    private int boardSize;
    private int[][] board;
    private final int userVal1 = 1;
    private final int userVal2 = -1;
    private boolean spaceClear;


    public TicTacToe(){
        this.boardSize = 3;
        this.board = new int[boardSize][boardSize];
    }

    public void pieceOnBoard(int row, int column, int userVal){
            board[row][column] = userVal;
    }

    public boolean checkPieceOnBoard(int row, int column) {
        if (board[row][column] == 0) {
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
            sumDiag2 += board[boardSize - i][i];
        }
        if (checkSum(sumDiag2)){
            return sumDiag2 / boardSize;
        }

        return 0;
    }
    private boolean checkSum(int sum){
        if (sum == (boardSize * userVal1) || sum == (boardSize *
                userVal2)) {
            return true;
        }
        return false;
    }
}
