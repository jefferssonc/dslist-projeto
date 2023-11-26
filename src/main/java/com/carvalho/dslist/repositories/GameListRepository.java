package com.carvalho.dslist.repositories;

import com.carvalho.dslist.entities.Game;
import com.carvalho.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
