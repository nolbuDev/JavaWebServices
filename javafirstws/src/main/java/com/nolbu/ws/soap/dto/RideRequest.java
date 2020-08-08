package com.nolbu.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;

import com.nolbu.ws.soap.dto.Ride;

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
