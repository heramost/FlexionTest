package com.flexionmobile.codingchallenge.funflowers;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Billing implements Integration {
	private static String baseUrl = "http://sandbox.flexionmobile.com/javachallenge/rest/developer/HeraZoltan";
	private static ObjectMapper mapper = new ObjectMapper();

	public Purchase buy(String str) {
		System.out.println("Buy started");
		System.out.println("Item: " + str);
		System.out.println("URL: " + baseUrl + "/buy/" + str);
		Bill bill = null;
		try {
			URL url = new URL(baseUrl + "/buy/" + str);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			bill = mapper.readValue(br, Bill.class);

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		System.out.println("Buy finished");
		return bill;
	}

	public void consume(Purchase purchase) {
		System.out.println("Consume started");
		System.out.println("Id: " + purchase.getId());
		System.out.println("URL: " + baseUrl + "/consume/" + purchase.getId());
		try {
			URL url = new URL(baseUrl + "/consume/" + purchase.getId());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		System.out.println("Consume finished");
	}

	public List getPurchases() {
		System.out.println("Getting list started");
		System.out.println("URL: " + baseUrl + "/all");
		Purchases purchases = new Purchases();
		try {
			URL url = new URL(baseUrl + "/all");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));


			purchases = mapper.readValue(br, Purchases.class);
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		System.out.println("Getting list finished");
		return purchases.getPurchases();
	}

}
