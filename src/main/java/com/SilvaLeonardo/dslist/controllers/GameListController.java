package com.SilvaLeonardo.dslist.controllers;

import com.SilvaLeonardo.dslist.dto.GameListDTO;
import com.SilvaLeonardo.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findLists(){
        return gameListService.findLists();
    }
}
