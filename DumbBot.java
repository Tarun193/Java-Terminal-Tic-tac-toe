import java.util.Random;

// Dumb bot is going to 
public class DumbBot {
    private char playerChar;
    private String greeting = "\n\nHello, pal, I am dumb. \nMost likely you are going to win";

    public DumbBot(char playerChar) {
        this.playerChar = playerChar;

    }

    public void makeMove(Board board) {
        Random random = new Random();
        int num1 = random.nextInt(3);
        int num2 = random.nextInt(3);
        // marking untill the right spot got marked
        while (!board.markBoard(num1, num2, playerChar)) {
            num1 = random.nextInt(3);
            num2 = random.nextInt(3);
        }
        System.out.printf("I Played from my side at %d, it's your turn", num1 * 3 + num2 + 1);
    }

    // Function for intial greeting
    public void displayGreeting() {
        System.out.println(greeting);
    }
}
