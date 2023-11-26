package com.carvalho.dslist.repositories;

import com.carvalho.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
