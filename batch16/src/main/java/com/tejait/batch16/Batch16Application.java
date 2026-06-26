package com.tejait.batch16;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients//Tells the spring to accept the third party link
//And helps us to fetch the third party data
@SpringBootApplication
public class Batch16Application {
public static final Logger logger=LogManager.getLogger(Batch16Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Batch16Application.class, args);
		logger.debug("Debug method");// for developer use case
		logger.info("info method");// production use case
		logger.warn("Warn method");//To show warning logs
		logger.error("Error method");// To show error logs
		logger.fatal("Fatal Method");//to show server or debug issues logs
		
	}

}
