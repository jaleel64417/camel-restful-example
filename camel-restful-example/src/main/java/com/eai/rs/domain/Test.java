package com.eai.rs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		for (int i = 1; i <= 30; i++) {
			list.add("hello"+i);
		}

		Scanner input = new Scanner(System.in);
		int next = input.nextInt();
		int defaultSize = 5;
		int initial = 0;
		initial = (defaultSize * next);
		defaultSize = initial + 5;

		for (int i = initial; i < defaultSize; i++) {
			System.out.println(list.get(i));
		}

		input.close();
	}

}
