public class IntelligentBot {
    private char playerChar;
    private char humanChar;
    private String greeting = "\n\nHello, pal, I my name is Smarty\nif you won you gonna get free Pizza.";

    public IntelligentBot(char playerChar) {
        this.playerChar = playerChar;
        humanChar = (playerChar == 'X') ? 'O' : 'X';

    }

    // Function to make move aptimially using minimax algorithm.
    public void makeMove(Board board) {
        int move[] = new int[2];
        int score = 0;
        int bestScore = Integer.MIN_VALUE;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getCharAt(row, col) == ' ') {
                    board.markBoard(row, col, playerChar);
                    score = Minimax.minimax(board, 0, false, humanChar, playerChar);
                    if (bestScore < score) {
                        bestScore = score;
                        move = new int[] { row, col };
                    }
                    board.unmarkBoard(row, col);
                }
            }
        }
        // Function for intial greeting
        board.markBoard(move[0], move[1], playerChar);
        System.out.printf("I Played from my side at %d, it's your turn\nhave a good one", move[0] * 3 + move[1] + 1);
    }

    public void displayGreeting() {
        System.out.println(greeting);
    }
}
