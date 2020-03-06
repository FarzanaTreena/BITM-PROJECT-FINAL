package com.tigerit.TestProjectByTreena.DTO;

public class FlightFinderDTO {
	
	private String passenger;
	private String depart;
	
	public String getPassenger() {
		return passenger;
	}
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	//turns into string values
	@Override
	public String toString() {
		return "FlightFinderDTO [passenger=" + passenger + ", depart=" + depart + "]";
	}

}
