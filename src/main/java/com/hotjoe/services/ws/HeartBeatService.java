package com.hotjoe.services.ws;


import com.hotjoe.services.model.response.HeartbeatResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



/**
 * Provides a simple heartbeat.
 *
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HeartBeatService {

	public HeartBeatService() {
	}

	/**
	 * Get the heartbeat.  Basically if you can hit this "service"
	 * then the machine and process are up.
	 * 
	 * @return a simple "OK" text response packet.
	 * 
	 */

	@WebMethod
	public HeartbeatResponse getHeartBeat() {
		return new HeartbeatResponse("OK");
	}
}