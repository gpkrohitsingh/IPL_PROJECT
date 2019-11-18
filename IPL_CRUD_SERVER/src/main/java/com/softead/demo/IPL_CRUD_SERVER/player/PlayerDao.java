package com.softead.demo.IPL_CRUD_SERVER.player;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao {

	public void deleteById(int id);

	public List<Player> getAllPlayers();

}
