import java.util.Scanner;
import java.util.Random;

public class game {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    private static void gameloop() {
        boolean run = true;
        int choice = 0;
        while (run) {
            System.out.println("\n\nWelcome to Tic Tac Toe!!!\n");
            System.out.println("Choose the option:\n");
            System.out.println("1 - 1 Player");
            System.out.println("2 - 2 Player");
            System.out.println("9 - Exit");
            choice = input.nextInt();
            while (choice != 1 && choice != 2 && choice != 9) {
                System.out.println("Wrong Input, Please Try enter correct input!!!");
                choice = input.nextInt();
            }
            if (choice == 1) {
                onePlayer();

            } else if (choice == 2) {
                twoPlayer();

            } else if (choice == 9) {
                System.out.println("Bye, Have a good day :)");
                run = false;
                return;
            }

        }
    }

    static void twoPlayer() {
        char Player1 = 'X';
        char Player2 = 'O';
        System.out.println("\n\nPlayer 1: X");
        System.out.println("Player 2: O\n\n");
        char winner = ' ';
        boolean turn = random.nextBoolean();
        int num1;
        int num2;
        Board board = new Board();
        board.displayBoard();
        while (winner == ' ') {
            if (turn) {
                System.out.println("Player 1 turn, Mark in between(1-9) at empty spots:");
                try {
                    num1 = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wong Input!!");
                    input.nextLine();
                    continue;
                }
                if (board.markBoard(num1, Player1)) {
                    turn = !turn;
                }
            } else {
                System.out.println("Player 2 turn, Mark in between(1-9) at empty spots:");
                try {
                    num2 = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wong Input!!");
                    input.nextLine();
                    continue;
                }
                if (board.markBoard(num2, Player2)) {
                    turn = !turn;
                }
            }
            winner = board.boardStatus();
            board.displayBoard();
        }
        System.out.println("Player " + winner + " Wins");

    }

    static void onePlayer() {
        System.out.println("\n\nPlease chose the level!!\n");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        int choice = 0;
        choice = input.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Enter the correct choice!!");
            choice = input.nextInt();
        }
        if (choice == 1) {
            easyLevel();
        }
        if (choice == 2) {
            mediumLevel();
        }
        if (choice == 3) {
            hardLevel();
        }

    }

    static void hardLevel() {
        input.nextLine();
        System.out.println("Select from X or O: ");
        char Human = input.nextLine().toUpperCase().charAt(0);
        while (!checkInput(Human)) {
            System.out.println("Wrong Input, please select from X or O: ");
            Human = input.nextLine().toUpperCase().charAt(0);
        }
        char botchar = (Human == 'X') ? 'O' : 'X';
        IntelligentBot bot = new IntelligentBot(botchar);
        System.out.println("\n\nComputer: " + botchar + "\n");
        System.out.println("You: " + Human + "\n\n");
        bot.displayGreeting();
        Board board = new Board();
        char winner = ' ';
        boolean turn = random.nextBoolean();
        int num;
        board.displayBoard();
        while (winner == ' ') {
            if (turn) {
                System.out.println("Human Player turn, Mark in between(1-9) at empty spots:");
                try {
                    num = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wong Input!!");
                    input.nextLine();
                    continue;
                }
                if (board.markBoard(num, Human)) {
                    turn = !turn;
                }
            } else {
                bot.makeMove(board);
                turn = !turn;
            }
            winner = board.boardStatus();
            board.displayBoard();
        }
        winnerDisplay(winner);
    }

    static void mediumLevel() {
        input.nextLine();
        System.out.println("Select from X or O: ");
        char Human = input.nextLine().toUpperCase().charAt(0);
        while (!checkInput(Human)) {
            System.out.println("Wrong Input, please select from X or O: ");
            Human = input.nextLine().toUpperCase().charAt(0);
        }
        char botchar = (Human == 'X') ? 'O' : 'X';
        IntelligentBot ibot = new IntelligentBot(botchar);
        DumbBot dbot = new DumbBot(botchar);
        Board board = new Board();
        char winner = ' ';
        boolean turn = random.nextBoolean();
        boolean bturn = random.nextBoolean();
        int num;
        System.out.println("\n\nComputer: " + botchar + "\n");
        System.out.println("You: " + Human + "\n\n");
        System.out.println("Hello, All the best.");
        board.displayBoard();
        while (winner == ' ') {
            if (turn) {
                System.out.println("Human Player turn, Mark in between(1-9) at empty spots:");
                try {
                    num = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wong Input!!");
                    input.nextLine();
                    continue;
                }
                if (board.markBoard(num, Human)) {
                    turn = !turn;
                }
            } else {
                if (bturn) {
                    ibot.makeMove(board);
                    bturn = !bturn;
                } else {
                    dbot.makeMove(board);
                    bturn = !bturn;
                }
                turn = !turn;
            }
            winner = board.boardStatus();
            board.displayBoard();
        }
        winnerDisplay(winner);
    }

    static void easyLevel() {
        input.nextLine();
        System.out.println("Select from X or O: ");
        char Human = input.nextLine().toUpperCase().charAt(0);
        while (!checkInput(Human)) {
            System.out.println("Wrong Input, please select from X or O: ");
            Human = input.nextLine().toUpperCase().charAt(0);
        }
        char botchar = (Human == 'X') ? 'O' : 'X';
        DumbBot bot = new DumbBot(botchar);
        System.out.println("\n\nComputer: " + botchar + "\n");
        System.out.println("You: " + Human + "\n\n");
        bot.displayGreeting();
        Board board = new Board();
        char winner = ' ';
        boolean turn = random.nextBoolean();
        int num;
        board.displayBoard();
        while (winner == ' ') {
            if (turn) {
                System.out.println("Human Player turn, Mark in between(1-9) at empty spots:");
                try {
                    num = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Wong Input!!");
                    input.nextLine();
                    continue;
                }
                if (board.markBoard(num, Human)) {
                    turn = !turn;
                }
            } else {
                bot.makeMove(board);
                turn = !turn;
            }
            winner = board.boardStatus();
            board.displayBoard();
        }
        winnerDisplay(winner);
    }

    public static void winnerDisplay(char win) {
        if (win == 'X') {
            System.out.println("\n----------- :) Player X wins -----------\n");
        } else if (win == 'O') {
            System.out.println("\n----------- :) Player O wins -----------\n");
        } else {
            System.out.println("\n---------------- It's a tie ---------------\n");
        }
    }

    // utility function
    static boolean checkInput(char chk) {
        if (chk != 'O' && chk != 'X') {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        gameloop();
    }

}
