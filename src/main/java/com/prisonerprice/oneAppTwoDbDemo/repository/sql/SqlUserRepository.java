package com.prisonerprice.oneAppTwoDbDemo.repository.sql;

import com.prisonerprice.oneAppTwoDbDemo.entity.sql.SqlUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlUserRepository extends JpaRepository<SqlUser, Integer> {
     SqlUser findSQLUserByName(String name);
}
