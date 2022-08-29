package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;
import static java.time.Month.AUGUST;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           Student laye= new Student(
                "Ba",
                 "laye",
                 LocalDate.of(2000,JANUARY,22)
            );
                    Student aliou = new Student(
                            "Thiam",
                            "aliou",
                            LocalDate.of(1993,AUGUST,22)
                    );
            repository.saveAll(List.of(laye,aliou));

        };

    };

}
