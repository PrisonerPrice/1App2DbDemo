package com.prisonerprice.oneAppTwoDbDemo.repository;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import com.prisonerprice.oneAppTwoDbDemo.repository.mango.MangoTeamRepository;
import com.prisonerprice.oneAppTwoDbDemo.repository.sql.SqlTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {

    @Autowired
    MangoTeamRepository mangoTeamRepository;

    @Autowired
    SqlTeamRepository sqlTeamRepository;

    private static boolean useMango;

    // useMangoProperty: if set to true, we use MangoDB, otherwise, we use MySQL
    public TeamRepository(@Value("${appconfig.usemongo}") String useMangoProperty) {
        useMango = useMangoProperty.equals("true");
    }

    public List<Team> findAll() {
        if (useMango)
            return mangoTeamRepository.findAll();
        else
            return sqlTeamRepository.findAll();
    }

    public Team save(Team group) {
        if (useMango)
            return mangoTeamRepository.save(group);
        else
            return sqlTeamRepository.save(group);
    }

}
