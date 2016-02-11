import java.util.*;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		Scanner user = new Scanner (System.in);
		//for user input
		
		System.out.print("Enter player name: ");
		String name = user.next();
		System.out.print("How many rounds would you like to play?: ");
		double maxRounds = user.nextDouble();
		int winCount = 0;
		int round = 0;
		gameStart(name, maxRounds, winCount, round);
		//declare variables and move to the game method
	}
	
	public static void gameStart(String name, double maxRounds, int winCount, int round) {
		
		Scanner user = new Scanner (System.in);
		Random rand = new Random();
		//for random int and user input
		
		do{
			String throwStr = "";
			//had to put something in throwStr for it to work with the loop
			System.out.println();
			System.out.print("Enter your throw (0=Rock, 1=Paper, 2=Scissors): ");
			int throwNum = user.nextInt();
			if (throwNum == 0) {
				throwStr = "ROCK";
			}else
			if (throwNum == 1) {
				throwStr = "PAPER";
			}else
			if (throwNum == 2) {
				throwStr = "SCISSORS";
			}else
			//puts the throw number into a string
			if (throwNum != 0 && throwNum != 1 && throwNum != 2) {
				System.out.println();
				System.out.println("Error: Please try again");
				System.out.println();
				gameStart(name, maxRounds, winCount, round);
				break;
				//goes to the game method again if you input an unusable integer
			}
			System.out.println(name + " throws " + throwStr);
			int cpuThrow = rand.nextInt(3);
			if (cpuThrow == 0) {
				throwStr = "ROCK";
			}else
			if (cpuThrow == 1) {
				throwStr = "PAPER";
			}else
			if (cpuThrow == 2) {
				throwStr = "SCISSORS";
			}
			//puts throw number into a string
			System.out.println("The Computer throws " + throwStr);
			if ((throwNum == 0 && cpuThrow == 2) || (throwNum == 1 && cpuThrow == 0) || (throwNum == 2 && cpuThrow == 1)) {
				System.out.println(name + " wins!");
				winCount++;
				round++;
			}else
			if (throwNum == cpuThrow) {
				System.out.println("Tie!");
			}else
			if ((throwNum == 2 && cpuThrow == 0) || (throwNum == 0 && cpuThrow == 1) || (throwNum == 1 && cpuThrow == 2)) {
				System.out.println("The Computer wins!");
				round++;
			}
			//these if statements determine who wins or if it ties
		}while(round < maxRounds);
		//ends after the selected amount of rounds (ties don't count toward round count)
		if (round == maxRounds) {
			if (winCount == maxRounds/2) {
				System.out.println();
				System.out.println("It's a tie!");
				}else
			if (winCount > maxRounds/2) {
				System.out.println();
				System.out.println(name + " is the winner!");
				}else
				if (winCount < maxRounds/2) {
				System.out.println();
				System.out.println("The Computer is the winner!");
				//prints out who won, or if it was a tie
			}
		}
	}

}
