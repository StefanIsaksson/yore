package com.bliska.dinosauria;

import com.bliska.dinosauria.model.*;
import com.bliska.dinosauria.repository.CladeRepository;
import com.bliska.dinosauria.repository.DinosaurRepository;
import com.bliska.dinosauria.repository.FossileSiteRepository;
import com.bliska.dinosauria.service.TyrannosaurursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootApplication
public class DinosauriaApplication {

	private static final Logger log = LoggerFactory.getLogger(DinosauriaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DinosauriaApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(TyrannosaurursService tyrannosaurursService) {
		return (args) -> {
			tyrannosaurursService.saveTyrannosaurus();
		};
	}

	}
