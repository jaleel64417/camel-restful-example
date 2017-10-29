package com.eai.rs.service;

import com.eai.rs.domain.FizzBuzzRequest;
import com.eai.rs.domain.FizzBuzzResponse;

public interface FizzBuzzService {

	FizzBuzzResponse printResult(FizzBuzzRequest request);

}