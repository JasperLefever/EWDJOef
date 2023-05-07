package com.springBoot.jpaMysql_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import domain.Guest;
import repository.GuestRepository;

@Component
public class InitDataConfig implements CommandLineRunner {

	@Autowired
	private GuestRepository repository;

	@Override
	public void run(String... args) {

		repository.save(new Guest("Keters", "Sandra"));
		repository.save(new Guest("Blondeel", "Tania"));
		repository.save(new Guest("Blondeel", "Jurgen"));
		repository.save(new Guest("Blondeels", "Ann"));
	}

}
