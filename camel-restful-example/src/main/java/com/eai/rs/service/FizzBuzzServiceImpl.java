package com.eai.rs.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.eai.rs.domain.FizzBuzzRequest;
import com.eai.rs.domain.FizzBuzzResponse;


@Path("/")
public class FizzBuzzServiceImpl implements FizzBuzzService {
	
	/* (non-Javadoc)
	 * @see com.eai.rs.service.FizzBuzzService#printResult(com.eai.rs.domain.FizzBuzzRequest)
	 */
	@Override
	@Path("/printResult")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public FizzBuzzResponse printResult(@QueryParam("") FizzBuzzRequest request){
		return null; 
	}
}
