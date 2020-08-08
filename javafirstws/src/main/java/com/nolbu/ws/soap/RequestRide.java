package com.nolbu.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.nolbu.ws.soap.dto.RideRequest;
import com.nolbu.ws.soap.dto.RideResponse;

@WebService
public interface RequestRide {
	
	@WebMethod
	public @WebResult(name="response")RideResponse setRide(@WebParam(name="rideRequest") RideRequest rideRequest);
}
