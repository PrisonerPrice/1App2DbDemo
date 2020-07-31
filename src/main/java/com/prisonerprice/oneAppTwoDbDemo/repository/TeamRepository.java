package com.prisonerprice.oneAppTwoDbDemo.repository;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MongoTeamRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamRepository {

    @Autowired
    MongoTeamRepository mongoTeamRepository;

    @Autowired
    SqlTeamRepository sqlTeamRepository;

    private static boolean useMango;

    // useMangoProperty: if set to true, we use MangoDB, otherwise, we use MySQL
    public TeamRepository(@Value("${appconfig.usemongo}") String useMangoProperty) {
        useMango = useMangoProperty.equals("true");
    }

    public List<Team> findAll() {
        if (useMango)
            return mongoTeamRepository.findAll();
        else
            return sqlTeamRepository.findAll();
    }

    public Team save(Team group) {
        if (useMango)
            return mongoTeamRepository.save(group);
        else
            return sqlTeamRepository.save(group);
    }

    public List<User> findAllUsersBelongToATeam(String teamName) {
        Team team;
        if (useMango)
            team = mongoTeamRepository.findTeamByTeamName(teamName);
        else
            team = sqlTeamRepository.findTeamByTeamName(teamName);
        return team == null ? new ArrayList<>() : team.getUsers();
    }

    public void deleteAll() {
        if (useMango)
            mongoTeamRepository.deleteAll();
        else
            sqlTeamRepository.deleteAll();
    }

}
