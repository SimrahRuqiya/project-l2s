package org.example.l2s;

import org.example.l2s.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.example.l2s.model")
public class L2sApplication{

	public static void main(String[] args) {
		SpringApplication.run(L2sApplication.class, args);
	}

}

