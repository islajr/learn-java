package com.test.person.dao;

import com.test.person.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {

           Person victoria =  new Person(UUID.randomUUID(), "Victoria");
           Person isla = new Person(UUID.randomUUID(), "Isla");

           repository.saveAll(List.of(victoria, isla));

        };
    }
}
