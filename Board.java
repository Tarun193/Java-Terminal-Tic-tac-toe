public class Board {
    // 2D Array to store Making on the board;
    private char board[][] = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    // Function for print board on the screen.
    public void displayBoard() {
        // Printing two lines for Formatting
        System.out.println();
        System.out.println();
        // for rows of board
        for (int row = 0; row < board.length; row++) {
            // for columns of board
            // for spacing from left before printing first row of the board
            System.out.print("                   ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " ");
                if (col < 2) {
                    // Printing pipe symbol for separation of columns
                    System.out.print("   |   ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("                   ------+---------+------");
            }
        }
        // Printing two lines for Formatting
        System.out.println();
        System.out.println();
    }

    // marking the board with just number between 1 to 9
    public boolean markBoard(int num, char markchar) {
        if (num >= 10 || num <= 0) {
            System.out.println("Wrong input!!\nPlease Enter value(1-9):");
            return false;
        }
        num--;
        int row = num / 3;
        int col = num % 3;
        if (board[row][col] != ' ') {
            System.out.println("Operation failed!!, Place is already occupied");
            return false;
        }

        board[row][col] = markchar;
        return true;
    }

    // as computer is going to mark according row and column, so overloaded marked
    // function
    // with functionality of making according to rows and columns instead of single
    // number
    public boolean markBoard(int row, int col, char markchar) {
        if (board[row][col] != ' ') {
            return false;
        }
        board[row][col] = markchar;
        return true;
    }

    // It will unmark the board at specific postion
    public void unmarkBoard(int row, int col) {
        board[row][col] = ' ';
    }

    // It will return the character at given position.
    public char getCharAt(int i, int j) {
        return board[i][j];
    }

    // This function is going to return the the status of board i.e. its check
    // whather someone win or not or it is a tie
    // It return 'X' if X player wins , 'O' if O player wins 't' if it is a tie and
    // ' ' if nothing happened
    public char boardStatus() {
        char winner = ' ';
        // checking Each Row for wining
        // for rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]) {
                winner = board[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]) {
                winner = board[0][i];
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            winner = board[0][0];
        } else if (board[2][0] != ' ' && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            winner = board[2][0];
        }
        int openSpots = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    openSpots++;
                }
            }
        }
        if (winner == ' ' && openSpots == 0) {
            return 't';
        }
        return winner;
    }
}
