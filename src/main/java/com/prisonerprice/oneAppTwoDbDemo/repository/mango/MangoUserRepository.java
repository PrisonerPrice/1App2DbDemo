package com.prisonerprice.oneAppTwoDbDemo.repository.mango;

import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MangoUserRepository extends MongoRepository<User, Integer> {
    User findUserByName(String name);
}
