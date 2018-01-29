package com.flexionmobile.codingchallenge.funflowers;

import com.flexionmobile.codingchallenge.integration.IntegrationTestRunner;

public class Main {
	public static void main(String args[])
	{
		IntegrationTestRunner tester = new IntegrationTestRunner();
		tester.runTests(new Billing());
	}
}
