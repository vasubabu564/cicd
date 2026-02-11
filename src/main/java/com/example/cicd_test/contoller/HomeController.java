package com.example.cicd_test.contoller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cicd_test.service.ReportService;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ReportService reportService;

	@GetMapping("home")
	public ResponseEntity<?> home() {
		return new ResponseEntity<>("Welcome to CICD app..", HttpStatus.OK);
	}

	@GetMapping("report")
	public CompletableFuture<String> getReport() {
		return reportService.generateReport();
	}

}
