package com.atividade.wholesaler.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class Curl {

	private static URI createUri(String scheme, String host, String path, HashMap<String, String> parameters) throws URISyntaxException {
		URIBuilder uriBuilder = new URIBuilder().setScheme(scheme).setHost(host).setPath(path);
		parameters.forEach(
			(key, value) -> uriBuilder.setParameter(key, value)
		);
		return uriBuilder.build();
	}

	private static String formatResponse(HttpResponse httpResponse) throws IOException {
		ResponseHandler<String> handler = new BasicResponseHandler();
		return handler.handleResponse(httpResponse).toString();
	}

	private static HttpResponse getData(URI uri) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(uri);
		return client.execute(httpGet);
	}

	private static HttpResponse postData(URI uri) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(uri);
		return client.execute(httpPost);
	}

	private static HttpResponse putData(URI uri) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut httpPut = new HttpPut(uri);
		return client.execute(httpPut);
	}

	public static String makeRequest(String scheme, String host, String path, HashMap<String, String> parameters, String type) throws URISyntaxException, IOException {
		URI uri = createUri(scheme, host, path, parameters);
		HttpResponse response;

		switch (type){
			case "POST":
				response = postData(uri);
				break;
			case "PUT":
				response = putData(uri);
				break;
			default:
				response = getData(uri);
		}

		return formatResponse(response);
	}
}
