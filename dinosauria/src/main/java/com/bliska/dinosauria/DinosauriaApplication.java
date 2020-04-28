package com.bliska.dinosauria;

import com.bliska.dinosauria.service.TyrannosaurursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DinosauriaApplication {

	private static final Logger log = LoggerFactory.getLogger(DinosauriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DinosauriaApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(TyrannosaurursService tyrannosaurursService) {
		return (args) -> {
			tyrannosaurursService.createTyrannosaurus();
		};
	}

	}
