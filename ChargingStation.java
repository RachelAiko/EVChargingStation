/*Improvement Assignment : SuperCharger
 * This program computes the charging cost and time at a charging station, and calculates the total
 * cost and time for all stations. It also keeps track of complimentary charging.
 * Revised the classes to fit object oriented practices.
 * Revised to include file I/O
 * author Rachel Matthews
 */
package SuperCharger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ChargingStation {
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		// Variables to keep track of totals
		double chargingCostTotal = 0, chargingTimeTotal = 0, complimentaryTimeTotal = 0, totalStationTime = 0,
				complimentaryCostTotal = 0, totalAllStalls = 0, complimentaryTime = 0, complimentaryCost = 0,
				chargingTotal = 0;
		double stallTotal = (double) 0;

		// Greeting to the user
		System.out.println("***** Welcome to Super Charger! ***********");
		System.out.println("Please enter the following information to set up the system:");
		System.out.println("Cost per kwh (In dollar amount, ie: If $0.12 then type 0.12): ");
		double electricCost = keyboard.nextDouble();
		System.out.println("The model of EV Model Number to recieve complimentary charging: ");
		double complimentaryVehicle = keyboard.nextDouble();
		System.out.println("If you would like to begin the program press 1: ");
		int answer = keyboard.nextInt();

		// Loop that controls the program flow
		while (answer == 1) {

			// Gets number of charging stalls from user
			System.out.println("Please enter the amount of Charging Stalls: ");
			int amountOfStalls = keyboard.nextInt();

			// Loop that keeps track of stalls
			for (int i = 0; i < amountOfStalls; i++) {
				int displayArray;
				displayArray = i + 1;
				stallTotal = stallTotal * 0;

				// Gets user input about the number of vehicles using a stall
				System.out.println("Please enter the number of vehicles charging at Stall " + displayArray + ":");
				int numVehicles = keyboard.nextInt();

				// Loop that gets user input about vehicle
				for (int x = 0; x < numVehicles; x++) {

					System.out.println("Please enter EV Model Number: ");
					double evModel = keyboard.nextDouble();

					System.out.println("Please enter battery capacity (For example if 50kWh, type 50): ");
					int batteryCapacity = keyboard.nextInt();

					System.out.println(
							"According to your socket rating, what is the voltage? (ie: Rating 120V,15A type 120): ");
					int volts = keyboard.nextInt();

					System.out.println(
							"According to your socket rating, what are the amperes? (ie: Rating 120V, 15A type 15): ");
					int amperes = keyboard.nextInt();

					System.out.println("Please enter current battery charge level:  ");
					double currentCharge = keyboard.nextDouble();

					System.out.println("Please enter desired charge level: ");
					int desiredCharge = keyboard.nextInt();

					// Quick Calculations of the amount to be charged, and the socket output
					double chargingAmount = (desiredCharge - currentCharge) / (double) 100;
					double socketOutput = ((volts * amperes) * 0.9) * .001;

					ChargingCost info = new ChargingCost(batteryCapacity, chargingAmount, electricCost,
							complimentaryVehicle, evModel);
					chargingCostTotal = info.getCost();

					ChargingTime info1 = new ChargingTime(batteryCapacity, chargingAmount, socketOutput,
							complimentaryVehicle, evModel);
					chargingTimeTotal = info1.getTime();

					ChargingTime info2 = new ChargingTime(batteryCapacity, chargingAmount, socketOutput,
							complimentaryVehicle, evModel);
					complimentaryTimeTotal = info2.getComplimentaryTime();

					// Displays individual vehicle charging costs and times
					System.out.println("************ Individual Vehicle Charges **********************\n");
					System.out.printf("Vehicle " + (x + 1) + " Charging Cost: $%1.2f\n", chargingCostTotal);
					System.out.printf("Vehicle " + (x + 1) + " Charging Time: %1.2f hours  \n", chargingTimeTotal);
					System.out.println("**************************************************************\n");

					// Keeps track of running totals 
					stallTotal += chargingCostTotal;
					chargingTotal += chargingTimeTotal;
					if (evModel != complimentaryVehicle) {
						complimentaryTime += 0;
					}
					else {
						complimentaryTime += chargingTimeTotal;
						complimentaryCostTotal += chargingCostTotal;
					}
					

					// Displays individual stall total
					System.out.printf("Stall " + (i + 1) + " total: $%1.2f\n", stallTotal);
					System.out.println("**************************************************************\n");
				}
			}

			// asks if they would like to enter another transaction / controls loop
			System.out.println("\nIf you would like to make an transasction press 1, if done press 0: ");
			int newAnswer = keyboard.nextInt();

			if (newAnswer == 0) {

				totalAllStalls += stallTotal;
				totalStationTime += chargingTotal;
				complimentaryTimeTotal += complimentaryTime;
				complimentaryCostTotal += complimentaryCost;
			
				// Writes to report file
				File outputFile = null;
				FileOutputStream outputFileStream = null;
				PrintWriter outputFileWriter = null;
				try {
					// write station totals to a file
					outputFile = new File("totalsReport.txt");
					outputFileStream = new FileOutputStream(outputFile);
					outputFileWriter = new PrintWriter(outputFileStream);
				}
				catch (IOException e) {
					System.out.println("FileWriter:main" + e.getMessage());
					System.exit(1);
				}	
				//writes information for each vehicle passing through
				outputFileWriter.println("************ Total for all Stalls ***************************\n");
				outputFileWriter.printf("Overall Station Revenue Total: $%1.2f\n", totalAllStalls);
				outputFileWriter.printf("Overal Station Charging Times: %1.2f\n", totalStationTime);
				outputFileWriter.println("\n************ Complimentary Totals *******************************\n"); 
				outputFileWriter.printf("Total Cost of Complimentary Charging: $%1.2f\n",complimentaryCostTotal);
				outputFileWriter.printf("Total Complimentary Time: %1.2f\n" , complimentaryTimeTotal); 
			
				
				//close the stream
				outputFileWriter.close();
				
			// Reads from Totals Report
			try {
				// reads from vehicle report
				Scanner fileReader = new Scanner(new File("totalsReport.txt"));
				while (fileReader.hasNext()) {
					String str = fileReader.nextLine();
					System.out.println(str);
				}
					
				// close the stream
				fileReader.close();
			}
			catch (IOException e) {
				System.out.println("In catch block two, reading from file");
				System.out.println("FileWriter:main" + e.getMessage());
				System.exit(1);
			}
			break;
		}

		else if (newAnswer == 1) {
			continue;
		}
		

		else if (newAnswer == 1) {
			continue;
		} 
		else {
			System.out.println("Please enter 1 to enter a transaction, or 0 if done: ");
			newAnswer = keyboard.nextInt();
			}

		}
		// close the keyboard
		keyboard.close();

	}

}
