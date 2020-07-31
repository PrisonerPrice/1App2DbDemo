package com.prisonerprice.oneAppTwoDbDemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long mysqlId;

    @org.springframework.data.annotation.Id
    @Column(name = "user_mango_id")
    private String mangoId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public User() { }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public User(Long mysqlId, String mangoId, String name, Team team) {
        this.mysqlId = mysqlId;
        this.mangoId = mangoId;
        this.name = name;
        this.team = team;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "User{" +
                "mysqlId=" + mysqlId +
                ", mangoId='" + mangoId + '\'' +
                ", name='" + name + '\'' +
                ", team=" + team.getTeamName() +
                '}';
    }
}
