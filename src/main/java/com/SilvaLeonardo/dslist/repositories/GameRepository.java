package com.SilvaLeonardo.dslist.repositories;

import com.SilvaLeonardo.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
