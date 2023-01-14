// Minimax class containing 

public class Minimax {
    // the scores are arranged in the form of ai wins win, tie and human wins;

    static public int minimax(Board board, int depth, boolean maximizing, char human, char ai) {
        char winner = board.boardStatus();
        if (winner == ai) {
            return 1;
        }
        if (winner == human) {
            return -1;
        }
        if (winner == 't') {
            return 0;
        }
        // maximizing the score when computer is playing
        if (maximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.getCharAt(row, col) == ' ') {
                        board.markBoard(row, col, ai);
                        bestScore = Math.max(minimax(board, depth + 1, false, human, ai), bestScore);
                        board.unmarkBoard(row, col);
                    }
                }
            }
            return bestScore;
        } // else we have to minize the score when human is play
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board.getCharAt(row, col) == ' ') {
                        board.markBoard(row, col, human);
                        bestScore = Math.min(minimax(board, depth + 1, true, human, ai), bestScore);
                        board.unmarkBoard(row, col);
                    }
                }
            }
            return bestScore;
        }
    }
}
