package SuperCharger;

public class ChargingStall {
	
	private double stallTotal, chargingTimeTotal, complimentaryTime, complimentaryCost;
	 
	public ChargingStall(double totalForStall, double stallChargeTime, double stallCompTime, double stallCompCost) {
		stallTotal = totalForStall;
		chargingTimeTotal = stallChargeTime;
		complimentaryTime = stallCompTime;
		complimentaryCost = stallCompCost;
	}
	// variable declarations for totals
	double totalAllStalls;
	double totalStationTime;
	double complimentaryTimeTotal;
	double complimentaryCostTotal;
	
	// Setters
	public void setStallTotal(double totalForStall) {
		stallTotal = totalForStall;
	}
	
	public void setChargingTimeTotal(double stallChargeTime) {
		chargingTimeTotal = stallChargeTime;
	}
	
	public void setComplimentaryTime( double stallCompTime) {
		complimentaryTime = stallCompTime;
	}
	
	public void setComplimnetaryCost( double stallCompCost) {
		complimentaryCost = stallCompCost;
	}
	
	// Getters
	// Calculates stalls revenue total
	public double getTotalAllStalls() {
		totalAllStalls += stallTotal;
	return totalAllStalls;
	}
	// Calculates total charging time at station
	public double getTotalStationTime() {
		totalStationTime += chargingTimeTotal;
	return totalStationTime;
	}
	// Calculates total time of complimentary charging
	public double getcomplimentaryTimeTotal() {
		complimentaryTimeTotal += complimentaryTime;
	return complimentaryTimeTotal;
	}
	// Calculates total cost of the complimentary charging
	public double getcomplimentaryCostTotal() {
		complimentaryCostTotal += complimentaryCost;
	return complimentaryCostTotal;
	}
	
	


}
