package com.SilvaLeonardo.dslist.repositories;
import com.SilvaLeonardo.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}