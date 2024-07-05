import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOn = true;

        while (gameOn) {
            printBoard();
            playerMove(currentPlayer, scanner);
            gameOn = !isWinner(currentPlayer) && !isBoardFull();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        printBoard();
        if (isWinner('X')) {
            System.out.println("Player X wins!");
        } else  if (isWinner('0')) {
            System.out.println("The game is a tie!");
        } else {
            System.out.println("The game is a tie!");
        }
        scanner.close();
    }

    public static void printBoard()  {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if(j < 2) System.out.print("|");
            }
            System.out.println();
            if(i < 2) System.out.println("  -----");
        }
    }

    public static void playerMove(char player, Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + player + ",enter your move(row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = player;
                break;
            }else {
                System.out.println("This move is not valid");
            }
        }
    }

    public static boolean isWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board [i][2] == player) ||
                    (board[0][i] ==  player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] ==player && board[1][1]== player && board[2][0] == player);
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
}