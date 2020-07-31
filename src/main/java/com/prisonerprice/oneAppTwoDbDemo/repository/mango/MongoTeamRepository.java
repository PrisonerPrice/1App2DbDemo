package com.prisonerprice.oneAppTwoDbDemo.repository.mango;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoTeamRepository extends MongoRepository<Team, String> {
    Team findTeamByTeamName(String teamName);

    @Query(value = "{}")
    List<Team> findAllTeams();

    @Query(value = "{}",
            fields = "{'mysqlId': 0, 'mangoId': 0, 'teamName': 0}")
    List<Team> findAllTeamsOnlyContainUserField();

    @Query(value = "{'teamName': ?0}",
            fields = "{'mysqlId': 0, 'mangoId': 0, 'teamName': 0}")
    List<Team> findAllTeamsOnlyContainUserFieldByTeamName(String teamName);

}
