package com.softead.demo.IPL_CRUD_SERVER.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired 
	private TeamDao teamDao;
	
	//  using DAO implimentation we will use this code ........ 
	
	
			// return all players
			public List<Team> getTeamList() {
				List<Team> teamList = new ArrayList<>();
				teamList = teamDao.getTeamList();
				return teamList;
			}
			
			
			// get single Team using ID filed
			public Team getSingleTeam(int id) {
				Team team = new Team();
			    team = teamDao.getSingleTeamById(id);
				return team;
			}
	
			// return single team
			public Team getTeam(int id, String teamName){
				Team team = new Team();
			    team = teamDao.getTeamById(id, teamName);
				return team;
			}
			
			// save the team
			public void save(Team team) {
				System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111");
				teamDao.saveTeam(team);
			}
			
			// remove team
			public void deleteTeam(int id, String team) {
				teamDao.deleteTeam(id, team);
			}
	
	
			
			//   implementing using JPA
			
			
		// return all players
//		public List<Team> getTeamList() {
//			List<Team> teamList = new ArrayList<>();
//			teamRepository.findAll().forEach(teamList::add);
//			return teamList;
//		}
		
    	// return single team
//		public Team getTeam(int id){
//			Optional<Team> optionalTeam = teamRepository.findById(id);
//			if(optionalTeam.isPresent()){
//				return optionalTeam.get();
//			}
//			return null;
//		}
		
		// save the team
//		public void saveTeam(Team team) {
//			teamRepository.save(team);
//		}
		
		// update the team
		public void updateTeam(Team team) {
			teamRepository.save(team);
		}
		
		// remove team
//		public void deleteTeam(int id) {
//			teamRepository.deleteById(id);
//		}

		
		

}
