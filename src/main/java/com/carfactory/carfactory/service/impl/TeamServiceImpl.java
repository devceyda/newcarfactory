package com.carfactory.carfactory.service.impl;
//-----------------------------------------------------
// Title: TeamServicrImpl
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary: The database connection is obtained using the repository.getConnection() method from the Repository class.
//The code uses CallableStatement to execute stored procedures and ResultSet to retrieve the results.
//----------------------------------------------------
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carfactory.carfactory.entity.Team;
import com.carfactory.carfactory.repository.Repository;
import com.carfactory.carfactory.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    Repository repository = new Repository();
    private Team team;
    private List<Team> teamMembers;

    @Override
    public List<Team> getTeam() {
        teamMembers = new ArrayList<>();
        String query = "{CALL uspGetTeam}";

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs = cb.executeQuery();
            while (rs.next()) {
                team = new Team();
                team.setName(rs.getString("Name"));
                team.setSurname(rs.getString("Surname"));
                team.setPosition(rs.getString("Position"));
                team.setPortrait(rs.getString("Portrait"));
                teamMembers.add(team);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teamMembers;
    }

}
