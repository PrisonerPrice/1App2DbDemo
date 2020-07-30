package com.prisonerprice.oneAppTwoDbDemo.repository.mango;

import com.prisonerprice.oneAppTwoDbDemo.entity.mango.MangoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MangoUserRepository extends MongoRepository<MangoUser, String> {
    MangoUser findMangoUserByName(String name);
}
