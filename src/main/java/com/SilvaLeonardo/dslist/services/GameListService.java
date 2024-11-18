package com.SilvaLeonardo.dslist.services;

import com.SilvaLeonardo.dslist.dto.GameListDTO;
import com.SilvaLeonardo.dslist.repositories.GameListRepository;
import com.SilvaLeonardo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findLists(){
        var result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        var list = gameRepository.searchByList(listId);
        var obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for(int i = min; i<=max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
    }
}
