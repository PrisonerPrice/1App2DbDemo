package com.prisonerprice.oneAppTwoDbDemo.repository.sql;

import com.prisonerprice.oneAppTwoDbDemo.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlTeamRepository extends JpaRepository<Team, Long> {
}
