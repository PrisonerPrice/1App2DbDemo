package com.prisonerprice.oneAppTwoDbDemo.repository;

import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MangoUserRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    SqlUserRepository sqlUserRepository;

    @Autowired
    MangoUserRepository mangoUserRepository;

    private static boolean useMango;

    // useMangoProperty: if set to true, we use MangoDB, otherwise, we use MySQL
    public UserRepository(@Value("${appconfig.usemongo}") String useMangoProperty) {
        useMango = useMangoProperty.equals("true");
    }

    public List<User> findAll() {
        if (useMango)
            return mangoUserRepository.findAll();
        else
            return sqlUserRepository.findAll();
    }

    public User save(User user) {
        if (useMango)
            return mangoUserRepository.save(user);
        else
            return sqlUserRepository.save(user);
    }
}
