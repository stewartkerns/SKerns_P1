
package SKerns_P1;

public class TicTacToe {
    private int boardSize;
    private int[][] board;
    private final int userVal1;
    private final int userVal2;
    private boolean spaceClear;

    public TicTacToe(){
        this.boardSize = 3;
        this.board = new int[boardSize][boardSize];
        this.userVal1 = 1;
        this.userVal2 = 2;
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
                            case 2: {
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
}
