package SuperCharger;

public class ChargingTime {
	
private double batteryCapacity, chargingAmount, socketOutput, complimentaryVehicle, evModel;
	
	public ChargingTime(double capacity, double chargeAmount, double socket, double freeVehicle, double vehicleModel) {
		batteryCapacity = capacity;
		chargingAmount = chargeAmount;
		socketOutput = socket;
		complimentaryVehicle = freeVehicle;
		evModel = vehicleModel;
	}
	// Variable declarations for complimentary services
	double chargeTime;
	double complimentaryTime;
	
	// Setters
	public void setChargingAmount(double chargeAmount) {
		chargingAmount = chargeAmount;
	}
	
	public void setbatteryCapacity(double capacity) {
		batteryCapacity = capacity;
	}
	
	public void setSocketOutput(double socket) {
		socketOutput = socket;
	}
	public void setcomplimentaryVehicle(double freeVehicle) {
		complimentaryVehicle = freeVehicle;
	}
	
	public void setevModel(double vehicleModel) {
		evModel = vehicleModel;
	}
	
	// Getters
	// Charging time calculations
	public double getTime() {
		chargeTime =  (batteryCapacity * chargingAmount) / socketOutput;
		return chargeTime;
	}
	public double getComplimentaryTime() {
		if (evModel != complimentaryVehicle) {
			complimentaryTime += 0;
		}
		else {
			complimentaryTime += chargeTime;
		}
	return complimentaryTime;	
	}

}
