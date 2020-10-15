package SuperCharger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Vehicle {

	double currentCharge;
	double desiredCharge;
	double batteryCapacity;
	double evModel;

	public Vehicle(double modelNum, double capacity, double charge, double chargeDesired) {
		evModel = modelNum;
		batteryCapacity = capacity;
		currentCharge = charge;
		desiredCharge = chargeDesired;
		
	// Writes to report file
	File outputFile = null;
	FileOutputStream outputFileStream = null;
	PrintWriter outputFileWriter = null;	
	try {
		// write vehicle information
		outputFile = new File("vehicle.txt");
		outputFileStream = new FileOutputStream(outputFile);
		outputFileWriter = new PrintWriter(outputFileStream);
	}
	catch (IOException e) {
		System.out.println("FileWriter:main" + e.getMessage());
		System.exit(1);
	}	
	// writes vehicle information to file
	outputFileWriter.println(evModel);
	outputFileWriter.println(batteryCapacity);
	outputFileWriter.println(currentCharge);
	outputFileWriter.println(desiredCharge);
	
	//close the stream
	outputFileWriter.close();
	
	}
	

	
}