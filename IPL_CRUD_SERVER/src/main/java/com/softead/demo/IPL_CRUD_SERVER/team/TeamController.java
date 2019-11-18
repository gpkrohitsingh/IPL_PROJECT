package com.softead.demo.IPL_CRUD_SERVER.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public List<Team> getAllTeam(){
		return teamService.getTeamList();
	}
	
	@RequestMapping(value = "/teams/{id}", method = RequestMethod.GET)
	public Team getSingleById(@PathVariable int id){
		return teamService.getSingleTeam(id);
	}
	
	@RequestMapping(value = "/teams/{id}/{team}", method = RequestMethod.GET)
	public Team getTeamById(@PathVariable int id, @PathVariable String team){
		return teamService.getTeam(id, team);
	}
	
	@RequestMapping(value = "/teams/save", method = RequestMethod.POST, produces="application/json")
	public void saveTeam(@RequestBody Team team) {
		System.out.println("inside save...");
		teamService.save(team);
	}
	
	@RequestMapping(value = "/teams/update", method = RequestMethod.PUT)
	public void updateTeam(@RequestBody Team team) {
		teamService.updateTeam(team);
	}
	
	@RequestMapping(value = "/teams/delete/{id}/{team}", method = RequestMethod.GET)
	public void deleteTeam(@PathVariable int id, @PathVariable String team) {
		teamService.deleteTeam(id, team);
	}

}
