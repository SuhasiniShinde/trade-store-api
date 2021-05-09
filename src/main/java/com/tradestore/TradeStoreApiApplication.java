package com.tradestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradeStoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeStoreApiApplication.class, args);
	}

}
