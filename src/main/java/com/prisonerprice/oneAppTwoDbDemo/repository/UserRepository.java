package com.prisonerprice.oneAppTwoDbDemo.repository;

import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MangoUserRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import sun.tools.java.Environment;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    @Autowired
    SqlUserRepository sqlUserRepository;

    @Autowired
    MangoUserRepository mangoUserRepository;

    /*
    if set to true, we use MangoDB
    otherwise, we use MySQL
     */


    private static boolean useMango;

    public UserRepository(@Value("${appconfig.usemongo}") String useMangoProperty) {
        useMango = useMangoProperty.equals("true");
    }

    public List<User> findAll() {
        if (useMango)
            //return mangoUserRepository.findAll().stream().map(useMango -> useMango.toUser()).collect(Collectors.toList());
            return mangoUserRepository.findAll();
        else
            //return sqlUserRepository.findAll().stream().map(sqlUser -> sqlUser.toUser()).collect(Collectors.toList());
            return sqlUserRepository.findAll();
    }

    public String save(User user) {
        if (useMango) {
            mangoUserRepository.save(user);
            return "A mangoUser is saved";
        } else {
            sqlUserRepository.save(user);
            return "A sqlUser is saved";
        }
    }
}
