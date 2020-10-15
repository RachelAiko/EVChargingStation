package SuperCharger;

public class ChargingCost {
	
	private double batteryCapacity, chargingAmount, electricCost, complimentaryVehicle, evModel;

	public ChargingCost(double capacity, double chargeAmount, double kwhCost, double freeVehicle, double vehicleModel) {
		batteryCapacity = capacity;
		chargingAmount = chargeAmount;
		electricCost = kwhCost;
		complimentaryVehicle = freeVehicle;
		evModel = vehicleModel;
	}
	
	// Variable declarations
	double cost;
	double complimentaryCost;

	// Setters
	public void setChargingAmount(double chargeAmount) {
		chargingAmount = chargeAmount;
	}

	public void setbatteryCapacity(double capacity) {
		batteryCapacity = capacity;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setelectricCost(double kwhCost) {
		electricCost = kwhCost;
	}

	public void setcomplimentaryVehicle(double freeVehicle) {
		complimentaryVehicle = freeVehicle;
	}

	public void setevModel(double vehicleModel) {
		evModel = vehicleModel;
	}
	
	// Getters

	// Charging cost calculations
	public double getCost() {
		if (evModel != complimentaryVehicle) {
			cost = ((batteryCapacity * chargingAmount) * electricCost) / 0.9;
		} else {
			cost = 0;
		}
		return cost;
	}

	// Complimentary charging cost calculation
	public double getComplimentaryCost() {
		if (evModel != complimentaryVehicle) {
			complimentaryCost = 0;
		} else {
			complimentaryCost = ((batteryCapacity * chargingAmount) * electricCost) / 0.9;
		}
		return complimentaryCost;
	}


}
