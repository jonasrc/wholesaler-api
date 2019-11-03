package com.atividade.wholesaler.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Wholesaler {
	
	private static Map<String, String> wholesalerApi = new HashMap<String, String>() {{
		put("scheme", "http");
		put("host", "localhost:8090");
		put("postOrder", "/authenticate");
	}};
	
	public static String postOrder(String test) throws IOException, URISyntaxException {
		HashMap<String, String> parameters = new HashMap<String, String>();

		//Stringify JSON with products array
		parameters.put("test", test);

		String response = Curl.makeRequest(
				wholesalerApi.get("scheme"),
				wholesalerApi.get("host"),
				wholesalerApi.get("postOrder"),
				parameters,
				"POST");

		return response;
	}
}
