package com.nolbu.ws.dto;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class RideRequest {
	
	private Ride ride;

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}
	
	
}
