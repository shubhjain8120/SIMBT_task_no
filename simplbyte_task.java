import java.util.Scanner;

public class simplbyte_task {

    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';

    public static void main(String[] args) {

        initializeBoard();
        displayBoard();

        while (!gameOver()) {
            makeMove();
            displayBoard();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        char winner = getWinner();
        if (winner == ' ') {
            System.out.println("It's a tie!");
        } else {
            System.out.println(winner + " wins!");
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by a space: ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }

    public static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move. Row and column should be between 1 and 3.");
            return false;
        } else if (board[row][col] != ' ') {
            System.out.println("Invalid move. That spot is already taken.");
            return false;
        } else {
            return true;
        }
    }

    public static boolean gameOver() {
        return isBoardFull() || getWinner() != ' ';
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char getWinner() {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
            // Check columns
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }
        // No winner yet
        return ' ';
    }
}