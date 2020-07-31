package com.prisonerprice.oneAppTwoDbDemo;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import com.prisonerprice.oneAppTwoDbDemo.repository.TeamRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.UserRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MangoUserRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlUserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MangoUserRepository.class)
@EnableJpaRepositories(basePackageClasses = SqlUserRepository.class)
public class OneAppTwoDbDemoApplication implements CommandLineRunner {

	@Autowired
	private SqlUserRepository sqlUserRepository;

	@Autowired
	private MangoUserRepository mangoUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneAppTwoDbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//sqlUserRepository.deleteAll();
		//mangoUserRepository.deleteAll();

		Team awesomeTeam = teamRepository.save(new Team("AwesomeTeam"));

		User u1 = userRepository.save(new User("Tom", awesomeTeam));
		User u2 = userRepository.save(new User("Jimmy", awesomeTeam));

		System.out.println("I am in MongoDB and try to find all: \"" +
				mangoUserRepository.findAll());
		System.out.println("I am in MySQL and try to find all: \"" +
				sqlUserRepository.findAll());
		System.out.println("I am in general repository and try to find all: \"" +
				userRepository.findAll());
	}
}
