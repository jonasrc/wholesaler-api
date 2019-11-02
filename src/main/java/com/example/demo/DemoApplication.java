package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/")
	public String isAlive() {
		return "It's alive!";
	}

    @GetMapping("/test-curl")
    public String testCurl() throws URISyntaxException, ClientProtocolException, IOException {
        
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("mock-authentication-api.appspot.com")
                .setPath("/users")
//                .setParameter("q", "httpclient")
//                .setParameter("btnG", "Google Search")
//                .setParameter("aq", "f")
//                .setParameter("oq", "")
                .build();

        ResponseHandler<String> handler = new BasicResponseHandler();
        
        HttpClient client = HttpClientBuilder.create().build();
        
        HttpGet httpget = new HttpGet(uri);
        
        HttpResponse response = client.execute(httpget);
        
        String body = handler.handleResponse(response);
        
        return body;
    }

}
