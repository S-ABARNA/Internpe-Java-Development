package javaprograms;
import java.util.Scanner;
import java.util.Random;
public class Numberguessing 
{
	    public static void main(String[] args) 
	    {
	        Scanner sc = new Scanner(System.in);
            Random r = new Random();
	        int ComputerGuess = r.nextInt(500) + 1;
	        int Tries = 0;
	        int guess;
	        boolean win = false;
	        

	        System.out.println("Welcome  to the Number Guessing Game!");
	        System.out.println("I have randomly chosen a number between 1 and 500.");
	        System.out.println("Try to guess  number it!");
	        while (!win) 
	        {
	            System.out.print("Enter your guess number: ");
	            guess = sc.nextInt();
	            Tries++;

	            if (guess > ComputerGuess) 
	            {
	                System.out.println("It's too high.Try again.");
	            }
	            else if(guess< ComputerGuess) 
	            {
	                System.out.println("It's  too low.Try again ");
	            } 
	            else 
	            {
	                win = true;
	                System.out.println("Congratulations! You have guessed the correct number!");
	                System.out.println("It's took  only  " + Tries + " tries.");
	            }
	        }
	        sc.close();
	    }
}
