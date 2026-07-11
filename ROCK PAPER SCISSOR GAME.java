package javaprograms;
import java.util.Scanner;
import java.util.Random;
public class RockPaperScissors
{
	    public static void main(String[] args) 
	    {
	        Scanner sc = new Scanner(System.in);
	        Random random = new Random();
	        String[] choices = {"rock", "paper", "scissors"};
	        boolean Play = true;
	        while (Play) 
	        {
	            System.out.print("Enter rock, paper, or scissors (or 'quit' to exit): ");
	            String user = sc.nextLine().toLowerCase();
	            if (user.equals("quit")) 
	            {
	                Play= false;
	                break;
	            }
	            if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) 
	            {
	                System.out.println("Invalid input. Please try again.");
	                continue;
	            }
	            int computerChoiceIndex = random.nextInt(3);
	            String computer = choices[computerChoiceIndex];
	            System.out.println("Computer chose: " + computer);
	            if (user.equals(computer)) 
	            {
	                System.out.println("It's a tie!");
	            } 
	            else if ((user.equals("rock") && computer.equals("scissors")) ||
	                       (user.equals("paper") && computer.equals("rock")) ||
	                       (user.equals("scissors") && computer.equals("paper"))) 
	            {
	                System.out.println("You win the game!");
	            } 
	            else {
	                System.out.println("Computer wins the game!");
	            }
	        }
	        System.out.println("Thanks for playing!");
	        sc.close();
	    }
	}
