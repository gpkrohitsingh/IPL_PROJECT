package com.softead.demo.IPL_CRUD_SERVER.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public List<Player> getAllPlayer(){
		return playerService.getPlayerList();
	}
	
	@RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
	public Player getPlayerById(@PathVariable int id ){
		return playerService.getPlayer(id);
	}
	
//	@RequestMapping(value = "/players/{team}", method = RequestMethod.GET)
//	public Player getPlayerByTeam(@PathVariable String team ){
//		return playerService.getPlayerByTeam(team);
//	}
	
	@RequestMapping(value = "/players/save", method = RequestMethod.POST)
	public void savePlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
	}
	
	@RequestMapping(value = "/players/update", method = RequestMethod.PUT)
	public void updatePlayer(@RequestBody Player player) {
		playerService.updatePlayer(player);
	}
	
	@RequestMapping(value = "/players/delete/{id}", method = RequestMethod.GET)
	public void deletePlayer(@PathVariable int id) {
		System.out.println("44444444444444444444444444444444444444444444444444444");
		playerService.deletePlayer(id);
	}

}
