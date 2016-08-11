package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableCaching
public class Application {

    @Component
    static class Runner implements CommandLineRunner {

        private static final Logger log = LoggerFactory.getLogger(Application.class);

        @Autowired
        private BookRepository bookRepository;

        @Override
        public void run(String... args) throws Exception {
            log.info(".... Fetching books");
            for (int i = 0; i < 10; i++) {
                log.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
            }

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
