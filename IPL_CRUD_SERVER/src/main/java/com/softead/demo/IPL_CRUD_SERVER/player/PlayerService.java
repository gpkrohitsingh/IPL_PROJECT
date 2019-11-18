package com.softead.demo.IPL_CRUD_SERVER.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private PlayerDao playerDao;
	
	
	// using DAO implimention .............................

	
	// return all players
		public List<Player> getPlayerList() {
			List<Player> playerList = new ArrayList<>();
			playerList = playerDao.getAllPlayers();
			return playerList;
		}
	
	// remove player
		public void deletePlayer(int id) {
			playerDao.deleteById(id);
		}
	
	
	
	
	
	
	// using JPA Repository...................
	
	// return all players
//	public List<Player> getPlayerList() {
//		List<Player> playerList = new ArrayList<>();
//		playerRepository.findAll().forEach(playerList::add);
//		return playerList;
//	}

	// return single player
	public Player getPlayer(int id){
		Optional<Player> optionalPlayer = playerRepository.findById(id);
		if(optionalPlayer.isPresent()){
			return optionalPlayer.get();
		}
		return null;
	}
	
	
	// return list of player base on team
		public Player getPlayerByTeam(String team){
			Player player = new Player(10, "rohit", "bat", 50, 1000, 0,
					105, 0, 2, 1, 4, 20, 0,
					30, 10, 123, 50, "RCB");
			return player;
			
		}
	
	
	
	// save the player
	public void savePlayer(Player player) {
		playerRepository.save(player);
	}
	
	// update the player
	public void updatePlayer(Player player) {
		playerRepository.save(player);
	}
	
	// remove player
//	public void deletePlayer(int id) {
//		playerRepository.deleteById(id);
//	}

}
