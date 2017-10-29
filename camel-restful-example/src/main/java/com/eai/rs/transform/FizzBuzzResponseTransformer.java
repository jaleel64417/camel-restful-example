package com.eai.rs.transform;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.camel.Body;
import org.apache.camel.Exchange;

import com.eai.rs.domain.FizzBuzzRequest;
import com.eai.rs.domain.FizzBuzzResponse;

public class FizzBuzzResponseTransformer {

	public void responseMapper(@Body FizzBuzzRequest request, Exchange exchange) {
		FizzBuzzResponse response = new FizzBuzzResponse();
		String input = request.getInput();
		response.setMessage(fizzBuzzBusinessLogic(request, input));
		exchange.getIn().setBody(response.getMessage());
	}

	private String fizzBuzzBusinessLogic(FizzBuzzRequest request, String input) {
		StringBuilder builder = new StringBuilder();
		if (null != input) {
			boolean flag = input.matches("\\d+(\\.\\d+)?");
			if (flag && Integer.valueOf(input) > 0) {
				List<String> list = fizzBuzz(Integer.valueOf(input));
				int size = list.size();
				int initialValue = 0;
				int defaultSize = list.size() > 20 ? 20 : list.size();
				String page = request.getPage();
				if (page != null) {
					boolean pageFlag = page.matches("\\d+(\\.\\d+)?");
					if (size > defaultSize && pageFlag && Integer.valueOf(page) > 0) {
						initialValue = (defaultSize * Integer.valueOf(page));
						defaultSize = initialValue + ((size - initialValue) > 20 ? 20 : (size - initialValue));
					}
				}
				if (initialValue <= defaultSize) {
					builder.append("Print the list of values between " + (initialValue + 1) + " and " + defaultSize);
					if (null != page) {
						builder.append(" for page number " + page + "\n");
					} else {
						builder.append(" for page number 0 \n");
					}
				} else {
					builder.append("No data available for page number " + page + ", Please select valid page number");
				}
				for (int i = initialValue; i < defaultSize; i++) {
					builder.append(list.get(i));
				}
			} else {
				builder.append("Please enter valid positive integer value");
			}
		} else {
			builder.append("Input need to be set in the restful url like ?input=10");
		}

		return builder.toString();
	}

	private static List<String> fizzBuzz(int num) {
		List<String> list = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		for (int i = 1; i <= num; i++) {
			if (((i % 5) == 0) && ((i % 7) == 0))
				list.add(dayOfWeek == Calendar.WEDNESDAY ? "WizzWuzz\n" : "FizzBuzz\n");
			else if ((i % 5) == 0)
				list.add(dayOfWeek == Calendar.WEDNESDAY ? "Wizz\n" : "Fizz\n");
			else if ((i % 7) == 0)
				list.add(dayOfWeek == Calendar.WEDNESDAY ? "Wuzz\n" : "Buzz\n");
			else
				list.add(i + "\n");
		}
		return list;
	}
}
