package com.tejait.batch16;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Batch16Application {
public static final Logger logger=LogManager.getLogger(Batch16Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Batch16Application.class, args);
		logger.debug("Debug method");
		logger.info("info method");
		logger.warn("Warn method");
		logger.error("Error method");
		logger.fatal("Fatal Method");
		
	}

}
