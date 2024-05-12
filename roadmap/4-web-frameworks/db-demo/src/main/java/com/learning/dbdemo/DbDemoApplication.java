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

		storeInformationRepository.findByStoreName("Amazon").forEach(System.out::println);
	}
}
