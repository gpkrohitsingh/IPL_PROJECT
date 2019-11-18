package com.softead.demo.IPL_CRUD_SERVER.team;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface TeamDao {
	
	public List<Team> getTeamList();
	public Team getTeamById(int id, String teamName);
	public void saveTeam(Team team);
	public void updateTeam(Team team);
	public void deleteTeam(int id, String team);
	public Team getSingleTeamById(int id);
}
