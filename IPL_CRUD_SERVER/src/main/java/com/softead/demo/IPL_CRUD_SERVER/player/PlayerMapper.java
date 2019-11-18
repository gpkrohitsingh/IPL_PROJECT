package com.softead.demo.IPL_CRUD_SERVER.player;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.softead.demo.IPL_CRUD_SERVER.team.Team;

public class PlayerMapper implements RowMapper<Player> {

	@Override
	public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player = new Player();
		player.setId(rs.getInt("player_id"));
		player.setAverage(rs.getInt("average"));
		player.setBestWickets(rs.getInt("best_wickets"));
		player.setCatches(rs.getInt("catches"));
		player.setCenturies(rs.getInt("centuries"));
		player.setFifties(rs.getInt("fifties"));
		player.setFoures(rs.getInt("foures"));		
		player.setHighestScore(rs.getInt("highest_score"));
		player.setMatchesPlayed(rs.getInt("match_played"));
		player.setPlayerName(rs.getString("player_name"));
		player.setPreference(rs.getString("preference"));		
		player.setRuns(rs.getInt("runs"));
		player.setSixes(rs.getInt("sixes"));
		player.setStrikeRate(rs.getDouble("strike_rate"));
		player.setStumpings(rs.getInt("stumpings"));
		player.setTeam(rs.getString("team"));
		player.setThirties(rs.getInt("thirties"));
		player.setWickets(rs.getInt("wickets"));
		
		return player;

	}

}
