package com.learning.dbdemo;

import com.learning.dbdemo.entity.StoreInformation;
import com.learning.dbdemo.repository.StoreInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner {

	@Autowired
	StoreInformationRepository storeInformationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		StoreInformation storeInformation = new StoreInformation("Amazon", "All", "12345");
		storeInformationRepository.save(storeInformation);

		StoreInformation storeInformation2 = new StoreInformation("Flipkart", "All", "12345");
		storeInformationRepository.save(storeInformation2);

		StoreInformation storeInformation3 = new StoreInformation("Jumia", "All", "12345");
		storeInformationRepository.save(storeInformation3);

		StoreInformation storeInformation4 = new StoreInformation("Konga", "All", "12345");
		storeInformationRepository.save(storeInformation4);

		storeInformationRepository.findByStoreName("Amazon").forEach(System.out::println);
	}
}
