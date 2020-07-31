package com.prisonerprice.oneAppTwoDbDemo.repository;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import com.prisonerprice.oneAppTwoDbDemo.entity.User;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MongoTeamRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    @Autowired
    SqlUserRepository sqlUserRepository;

    @Autowired
    MongoTeamRepository mongoTeamRepository;

    private static boolean useMango;

    public UserRepository(@Value("${appconfig.usemongo}") String useMangoProperty) {
        // useMangoProperty: if set to true, we use MangoDB, otherwise, we use MySQL
        useMango = useMangoProperty.equals("true");
    }

    public List<User> findAll() {
        if (useMango)
            return mongoTeamRepository.findAllTeamsOnlyContainUserField().stream()
                    .flatMap(team -> team.getUsers().stream())
                    .collect(Collectors.toList());
        else
            return sqlUserRepository.findAll();
    }

    public User save(User user) {
        if (useMango) {
            if (user.getTeam() != null) {
                Team team = user.getTeam();
                user.setTeam(null);
                Set<User> users = new HashSet<>(team.getUsers());
                users.add(user);
                team.setUsers(new ArrayList<>(users));
                mongoTeamRepository.save(team);
                return user;
            } else {
                throw new IllegalArgumentException();
            }
        }
        else
            return sqlUserRepository.save(user);
    }

    public void deleteAll() {
        if (useMango) {
            List<Team> teams = mongoTeamRepository.findAllTeams();
            for (Team team : teams) {
                team.setUsers(null);
            }
        }
        else
            sqlUserRepository.deleteAll();
    }

}
