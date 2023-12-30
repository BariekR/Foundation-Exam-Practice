public class TicTacToe {
    public static int isSolved(int[][] board) {
        if (numberIsWinning(board, 1)) {
            return 1;
        } else if (numberIsWinning(board, 2)) {
            return 2;
        } else if (containsZero(board)) {
            return -1;
        }
        
        return 0;
    }
    
    public static boolean containsZero(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean numberIsWinning(int[][] board, int number) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != number) {
                    break;
                } else if (j == board.length - 1) {
                    return true;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != number) {
                    break;
                } else if (j == board.length - 1) {
                    return true;
                }
            }
        }

        if ((board[0][0] == number && board[1][1] == number && board[2][2] == number) ||
            (board[0][2] == number && board[1][1] == number && board[2][0] == number)) {
            return true;
        }

        return false;
    }
}
