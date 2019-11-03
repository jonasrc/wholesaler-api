package com.atividade.wholesaler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class WholesalerApplication {

	public static void main(String[] args) {
	    SpringApplication.run(WholesalerApplication.class, args);
	}
}
