package com.onlyalec.oracleOne.LibreriaAPI;

import com.onlyalec.oracleOne.LibreriaAPI.main.MainProgram;
import com.onlyalec.oracleOne.LibreriaAPI.repository.AutorRepository;
import com.onlyalec.oracleOne.LibreriaAPI.repository.LibroRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaApiApplication implements CommandLineRunner {

    @Autowired
    LibroRepostory libroRepostory;

    @Autowired
    AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibreriaApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MainProgram main = new MainProgram(libroRepostory, autorRepository);
        main.menu();
    }
}
