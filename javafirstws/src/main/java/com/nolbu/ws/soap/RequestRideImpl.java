package com.nolbu.ws.soap;

import java.util.ArrayList;
import java.util.List;

import com.nolbu.ws.soap.dto.Ride;
import com.nolbu.ws.soap.dto.RideRequest;
import com.nolbu.ws.soap.dto.RideResponse;

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
