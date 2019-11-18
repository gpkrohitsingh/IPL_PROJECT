package com.softead.demo.IPL_CRUD_SERVER.player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

}
