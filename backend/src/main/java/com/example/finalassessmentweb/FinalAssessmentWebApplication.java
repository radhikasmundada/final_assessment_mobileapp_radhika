package com.example.finalassessmentweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FinalAssessmentWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAssessmentWebApplication.class, args);
	}

	@GetMapping("/test")
	public String test() {
		return "working";
	}
}
