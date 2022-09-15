package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		int startAmount;
		int originalStartAmount;
		double winChance;
		int winLimit;
		int totalSimulations;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please insert your starting amount: ");
		originalStartAmount = input.nextInt();
		
		System.out.println("Please insert your win chance as a value between 0-1: ");
		winChance = input.nextDouble();
		
		System.out.println("Please insert your win limit: ");
		winLimit = input.nextInt();
		
		System.out.println("Please insert the number of simulations you'd like to run: ");
		totalSimulations = input.nextInt();
		
		int success = 0;
		int ruin = 0;
		
		for (int i = 1; i <= totalSimulations; i++) { // per simulations
			startAmount = originalStartAmount;
			int rounds = 0;
			while (startAmount > 0 && startAmount < winLimit) { // per day
				double chance = Math.random();
				
				if (chance < winChance) { // per round
					startAmount++;
					rounds++;
				}
				else if (chance >= winChance) {
					startAmount--;
					rounds++;
				}
			}
			
			String outputWL;
			
			if (startAmount == 0) {
				ruin++;
				outputWL = "LOSS";
			}
			else {
				success++;
				outputWL = "WIN";
				
			}
			
			System.out.println("Simulation " + i + ": " + rounds + " " + outputWL);
		}
		
		double expectedRuinRate = (double) ruin / totalSimulations;
		System.out.println("Your expected ruin rate is: " + expectedRuinRate);

	}

}
