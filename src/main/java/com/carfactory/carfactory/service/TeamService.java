package com.carfactory.carfactory.service;

import java.util.List;

import com.carfactory.carfactory.entity.Team;
//-----------------------------------------------------
// Title: TeamService
// Author: Ceyda Kuşçuoğlu, Berke Beyazbenli, Selin Sivis, Aybüke Ersal
// Section: 1,3
// Term Project
// Summary:This method is declared in the interface, and the actual implementation is expected to be provided in a class that implements the TeamService interface, such as the TeamServiceImpl class. The implementation class will provide the logic for fetching team-related information from the data source.
//----------------------------------------------------
public interface TeamService {

    List<Team> getTeam();
}
