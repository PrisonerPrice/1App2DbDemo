package com.prisonerprice.oneAppTwoDbDemo.repository.mango;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MangoTeamRepository extends MongoRepository<Team, String> {
}
