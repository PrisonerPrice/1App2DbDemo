package com.prisonerprice.oneAppTwoDbDemo;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import com.prisonerprice.oneAppTwoDbDemo.repository.TeamRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.UserRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MongoTeamRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlUserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MongoTeamRepository.class)
@EnableJpaRepositories(basePackageClasses = SqlUserRepository.class)
public class OneAppTwoDbDemoApplication implements CommandLineRunner {

	@Autowired
	private SqlUserRepository sqlUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private MongoTeamRepository mongoTeamRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneAppTwoDbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// truncate database
		userRepository.deleteAll();
		teamRepository.deleteAll();

		long t1 = System.currentTimeMillis();
		Team awesomeTeam = teamRepository.save(new Team("AwesomeTeam"));

		User u1 = userRepository.save(new User("Tom", awesomeTeam));
		User u2 = userRepository.save(new User("Jimmy", awesomeTeam));

		System.out.println("I am in MongoDB and try to find all users: \"" +
				mongoTeamRepository.findAllTeamsOnlyContainUserField());
		System.out.println("I am in MySQL and try to find all users: \"" +
				sqlUserRepository.findAll());
		System.out.println("I am in general repository and try to find all teams: \"" +
				teamRepository.findAll());
		System.out.println("I am in general repository and try to find all users: \"" +
				userRepository.findAll());
		System.out.println("I am in general repository and try to find all users belong to a group: \"" +
				teamRepository.findAllUsersBelongToATeam("AwesomeTeam"));
		System.out.println("Total time is: " + (System.currentTimeMillis() - t1));

		//userRepository.deleteAll();
		//teamRepository.deleteAll();
	}
}
