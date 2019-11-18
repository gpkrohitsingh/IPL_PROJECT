package com.softead.demo.IPL_CRUD_SERVER.team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.softead.demo.IPL_CRUD_SERVER.player.Player;

public class TeamMapper implements RowMapper<Team> {

	private List<Player> player;

//	public TeamMapper(List<Player> player) {
//		this.player = player;
//	}

	public TeamMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
		Team team = new Team();
		Player player = new Player();
		team.setId(rs.getInt("id"));
		team.setDescription(rs.getString("description"));
		team.setNoResult(rs.getInt("no_result"));
		team.setOwner(rs.getString("owner"));
		team.setTeam(rs.getString("team"));
		team.setTotalLost(rs.getInt("total_lost"));
		team.setTotalPlayed(rs.getInt("total_played"));
		team.setTotalWon(rs.getInt("total_won"));
//		team.setPlayers((List<Player>) player);
	    return team;
	}

}
