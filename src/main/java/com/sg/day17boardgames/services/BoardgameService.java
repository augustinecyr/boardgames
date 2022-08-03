package com.sg.day17boardgames.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.day17boardgames.repositories.BoardgameRepository;

@Service
public class BoardgameService {
    
    @Autowired
    private BoardgameRepository boardgameRepo;

    public String getBoardgameId(String id) {

        Optional<String> opt = boardgameRepo.get(id);
        String payload = opt.get();


        System.out.printf(">>> id: %s\n", id);
        System.out.printf(">>> payload: %s\n" , payload);
        
        return payload;

        
    }
}
