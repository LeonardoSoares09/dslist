package com.SilvaLeonardo.dslist.controllers;

import com.SilvaLeonardo.dslist.dto.GameListDTO;
import com.SilvaLeonardo.dslist.dto.GameMinDTO;
import com.SilvaLeonardo.dslist.dto.ReplacementDTO;
import com.SilvaLeonardo.dslist.services.GameListService;
import com.SilvaLeonardo.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findLists(){
        return gameListService.findLists();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
