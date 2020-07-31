package com.prisonerprice.oneAppTwoDbDemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long mysqlId;

    @org.springframework.data.annotation.Id
    @Column(name = "team_mango_id")
    private String mangoId;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    public Team() {
    }

    public Team(String groupName) {
        this.teamName = groupName;
    }

    public Team(String teamName, List<User> users) {
        this.teamName = teamName;
        this.users = users;
    }

    public Team(String mangoId, String groupName, List<User> users) {
        this.mangoId = mangoId;
        this.teamName = groupName;
        this.users = users;
    }

    public Long getMysqlId() {
        return mysqlId;
    }

    public void setMysqlId(Long mysqlId) {
        this.mysqlId = mysqlId;
    }

    public String getMangoId() {
        return mangoId;
    }

    public void setMangoId(String mangoId) {
        this.mangoId = mangoId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Team{" +
                "mysqlId=" + mysqlId +
                ", mangoId='" + mangoId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", users=" + users +
                '}';
    }
}
