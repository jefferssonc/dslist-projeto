package com.carvalho.dslist.services;


import com.carvalho.dslist.dto.GameDTO;
import com.carvalho.dslist.dto.GameListDTO;
import com.carvalho.dslist.dto.GameMinDTO;
import com.carvalho.dslist.entities.Game;
import com.carvalho.dslist.projections.GameMinProjection;
import com.carvalho.dslist.repositories.GameListRepository;
import com.carvalho.dslist.repositories.GameRepository;
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
    public List<GameListDTO> findAll(){
    var result = gameListRepository.findAll();
    List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
    return dto;
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        var list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);
        int min = sourceIndex < destinationIndex ? sourceIndex: destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex: sourceIndex;
        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }
    }
}
