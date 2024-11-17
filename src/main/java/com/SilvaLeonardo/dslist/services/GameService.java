package com.SilvaLeonardo.dslist.services;

import com.SilvaLeonardo.dslist.dto.GameDTO;
import com.SilvaLeonardo.dslist.dto.GameMinDTO;
import com.SilvaLeonardo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        var result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        var result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
