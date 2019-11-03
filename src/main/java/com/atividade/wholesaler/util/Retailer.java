package com.atividade.wholesaler.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Retailer {

	private static Map<String, String> retailerApi = new HashMap<String, String>() {{
		put("scheme", "http");
		put("host", "localhost:8080/api/v1");
		put("order", "/order");
	}};

	public static String putOrder(String requestBody) throws IOException, URISyntaxException {
		String response = Curl.makeRequest(
				retailerApi.get("scheme"),
				retailerApi.get("host"),
				retailerApi.get("order"),
				"PUT",
				requestBody);

		return response;
	}
}
