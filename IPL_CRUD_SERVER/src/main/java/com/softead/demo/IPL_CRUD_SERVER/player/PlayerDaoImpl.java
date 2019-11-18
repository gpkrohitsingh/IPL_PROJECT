package com.softead.demo.IPL_CRUD_SERVER.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.softead.demo.IPL_CRUD_SERVER.team.Team;
import com.softead.demo.IPL_CRUD_SERVER.team.TeamMapper;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Player> getAllPlayers() {
		String sql = "{call ipl_getAllPlayers()}";
		List <Player> players = jdbcTemplate.query(sql, new PlayerMapper());
		return players;
	}
	
	@Override
	public void deleteById(int id) {
		String sql = "{call ipl_deletePlayer(?)}";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	


}
