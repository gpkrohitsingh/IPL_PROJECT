package com.softead.demo.IPL_CRUD_SERVER.team;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softead.demo.IPL_CRUD_SERVER.player.Player;
import com.softead.demo.IPL_CRUD_SERVER.player.PlayerMapper;

@Repository
public class TeamDaoImpl implements TeamDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Team> getTeamList() {
//		String sql = "select * from ipl_crud.team";
		String sql = "{call ipl_getAllTeams()}";
		List <Team> team = jdbcTemplate.query(sql, new TeamMapper());
		return team;
	}
	
	@Override
	public Team getSingleTeamById(int id) {
		String sql = "select * from ipl_crud.team where id =?";
		Team team = jdbcTemplate.queryForObject(sql, new TeamMapper(), new Object[] { id });
		return team;	
	}

	@Override
	public Team getTeamById(int id, String teamName) {
		String sql = "select * from ipl_crud.team where id =?";
//		String sql = "{call ipl_getTeamById(?)}";
		String sql1 = "select * from ipl_crud.player where team = ?";
		List<Player> player = (List<Player>) jdbcTemplate.query(sql1, new PlayerMapper(), new Object[]{teamName});
		Team team = jdbcTemplate.queryForObject(sql, new TeamMapper(), new Object[] { id });
		team.setPlayers(player);
		return team;
	}

	@Override
	public void saveTeam(Team team) {
		System.out.println("222222222222222222222222222222222222222222222222222222222222222222222222222222222");
		String sql = "{call ipl_saveTeam(?,?,?,?,?,?,?,?)}";
		jdbcTemplate.update(sql, new Object[]{team.getId(), team.getDescription(),team.getNoResult(),
				            team.getOwner(),team.getTeam(),team.getTotalLost(),team.getTotalPlayed(),team.getTotalWon()});
//		jdbcTemplate.execute(sql);
		
	}

	@Override
	public void updateTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeam(int id, String team) {
		String sql = "{call ipl_deleteTeamAndPlayer(?,?)}";
		jdbcTemplate.update(sql, new Object[]{id, team});
	}


}
