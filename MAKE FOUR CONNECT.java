package javaprograms;
import java.util.Scanner;
public class ConnectFour
{
	    private static final int ROWS = 6;
	    private static final int COLS = 7;
	    private static final char EMPTY = '-';
	    private static final char PLAYER1 = 'X';
	    private static final char PLAYER2 = 'O';
	    private char[][] board = new char[ROWS][COLS];
	    private Scanner scanner = new Scanner(System.in);
	    public ConnectFour() 
	    {
	        initializeBoard();
	    }
	    private void initializeBoard() 
	    {
	        for (int i = 0; i < ROWS; i++) 
	        {
	            for (int j = 0; j < COLS; j++)
	            {
	                board[i][j] = EMPTY;
	            }
	        }
	    }
	    private void printBoard() 
	    {
	        for (int i = 0; i < ROWS; i++)
	        {
	            for (int j = 0; j < COLS; j++) 
	            {
	                System.out.print(board[i][j] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println("1 2 3 4 5 6 7"); 
	    }
	    private boolean dropPiece(int col, char player)
	    {
	        if (col < 0 || col >= COLS)
	        {
	            return false;
	        }
	        for (int row = ROWS - 1; row >= 0; row--)
	        {
	            if (board[row][col] == EMPTY) 
	            {
	                board[row][col] = player;
	                return true;
	            }
	        }
	        return false; 
	    }
	    private boolean checkForWin(char player)
	    {
	        return checkHorizontal(player) || checkVertical(player) || checkDiagonal(player);
	    }

	    private boolean checkHorizontal(char player) 
	    {
	        for (int row = 0; row < ROWS; row++)
	        {
	            for (int col = 0; col < COLS - 3; col++) 
	            {
	                if (board[row][col] == player && board[row][col + 1] == player
	                        && board[row][col + 2] == player && board[row][col + 3] == player) 
	                {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private boolean checkVertical(char player) 
	    {
	        for (int row = 0; row < ROWS - 3; row++) 
	        {
	            for (int col = 0; col < COLS; col++) 
	            {
	                if (board[row][col] == player && board[row + 1][col] == player
	                        && board[row + 2][col] == player && board[row + 3][col] == player) 
	                {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private boolean checkDiagonal(char player) 
	    {
	        for (int row = 0; row < ROWS - 3; row++) 
	        {
	            for (int col = 0; col < COLS - 3; col++) {
	                if (board[row][col] == player && board[row + 1][col + 1] == player
	                        && board[row + 2][col + 2] == player && board[row + 3][col + 3] == player) {
	                    return true;
	                }
	            }
	        }
	        for (int row = 0; row < ROWS - 3; row++) 
	        {
	            for (int col = 3; col < COLS; col++)
	            {
	                if (board[row][col] == player && board[row + 1][col - 1] == player
	                        && board[row + 2][col - 2] == player && board[row + 3][col - 3] == player) 
	                {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    public void playGame() 
	    {
	        boolean gameWon = false;
	        char currentPlayer = PLAYER1;
	        while (!gameWon) 
	        {
	            printBoard();
	            System.out.println("Player " + currentPlayer + ", choose a column from 1 to 7: ");
	            int col = scanner.nextInt() - 1;

	            if (dropPiece(col, currentPlayer)) 
	            {
	                if (checkForWin(currentPlayer)) 
	                {
	                    printBoard();
	                    System.out.println("Congratulations! Player " + currentPlayer + " wins the game!");
	                    gameWon = true;
	                } 
	                else {
	                      currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
	                }
	            } 
	            else {
	                System.out.println("Column is full or invalid. Try again.");
	            }
	        }
	    }
	    public static void main(String[] args) 
	    {
	        ConnectFour game = new ConnectFour();
	        game.playGame();
	    }
	}

