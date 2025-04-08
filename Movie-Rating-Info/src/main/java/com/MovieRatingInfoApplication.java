package com;

import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class MovieRatingInfoApplication {

	private static final Logger logger = LoggerFactory.getLogger(MovieRatingInfoApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(MovieRatingInfoApplication.class, args);
			logger.info("<<<<<<<<<<<< MovieRatingInfoApplication started successfully >>>>>>>>>>>>");
			if (args.length > 0) {
				logger.info("Application started with arguments:");
				for (String arg : args) {
					logger.info("ARG: {}", arg);
				}
			}
		} catch (Exception e) {
			logger.error("Application failed to start: {}", e.getMessage(), e);
		}
	}

	@PreDestroy
	public void onShutdown() {
		logger.info("<<<<<<<<<<<< MovieRatingInfoApplication is shutting down >>>>>>>>>>>>");
	}
}