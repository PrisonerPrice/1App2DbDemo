package com.prisonerprice.oneAppTwoDbDemo.repository.sql;

import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlUserRepository extends JpaRepository<User, Integer> {
     User findUserByName(String name);
}
