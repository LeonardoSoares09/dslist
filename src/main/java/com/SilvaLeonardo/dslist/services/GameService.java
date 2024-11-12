package com.SilvaLeonardo.dslist.services;

import com.SilvaLeonardo.dslist.dto.GameMinDTO;
import com.SilvaLeonardo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll() {
        var result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
