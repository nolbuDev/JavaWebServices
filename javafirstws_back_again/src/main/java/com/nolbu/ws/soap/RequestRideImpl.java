package com.nolbu.ws.soap;

import com.nolbu.ws.dto.RideRequest;
import com.nolbu.ws.dto.RideResponse;

import java.util.ArrayList;
import java.util.List;

import com.nolbu.ws.dto.Ride;

public class RequestRideImpl implements RequestRide {

	private List<Ride> rides;
	
	public RequestRideImpl() {
		rides = new ArrayList<Ride>();
	}
	
	@Override
	public RideResponse setRide(RideRequest rideRequest) {
		Ride ride = rideRequest.getRide();
		rides.add(ride);
		
		RideResponse response = new RideResponse();
		response.setResult(true);
		return response;
	}

}
