package com.example.student.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student isaac = new Student(
                    "Isaac",
                    21,
                    LocalDate.of(2003, MAY, 1),
                    "islarcherjr@gmail.com"
            );

            Student emmanuel = new Student(
                    "Emmanuel",
                    18,
                    LocalDate.of(2005, NOVEMBER, 13),
                    "emmanuelakinmokun@gmail.com"
            );

            repository.saveAll(List.of(isaac, emmanuel));

        };
    }
}
