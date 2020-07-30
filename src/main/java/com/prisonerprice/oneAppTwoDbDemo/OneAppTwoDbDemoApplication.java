package com.prisonerprice.oneAppTwoDbDemo;

import com.prisonerprice.oneAppTwoDbDemo.entity.mango.MangoUser;
import com.prisonerprice.oneAppTwoDbDemo.entity.sql.SqlUser;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MangoUserRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MangoUserRepository.class)
@EnableJpaRepositories(basePackageClasses = SqlUserRepository.class)
public class OneAppTwoDbDemoApplication implements CommandLineRunner {

	@Autowired
	private SqlUserRepository sqlUserRepository;

	@Autowired
	private MangoUserRepository mangoUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneAppTwoDbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sqlUserRepository.save(new SqlUser("Tom Hanks"));
		mangoUserRepository.save(new MangoUser("Tommy Hanks"));

		System.out.println(sqlUserRepository.findSQLUserByName("Tom Hanks").toString());
		System.out.println(mangoUserRepository.findMangoUserByName("Tommy Hanks").toString());
	}
}
