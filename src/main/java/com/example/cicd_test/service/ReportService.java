package com.example.cicd_test.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Async
    public CompletableFuture<String> generateReport() {
        try {
            System.out.println("Generating report in: " + Thread.currentThread().getName());
            Thread.sleep(3000); // Simulating long task
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread executing generateReport(): " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture("Report generated successfully!");
    }
}