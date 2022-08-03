package com.sg.day17boardgames.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.sg.day17boardgames.services.BoardgameService;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@RestController
@RequestMapping(path = "/boardgame")
public class BoardgameRestController {

    @Autowired
    private BoardgameService BoardgameSvc;

    @GetMapping(path="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getBoardgameId(@PathVariable String id) {

    
        
        String payload = BoardgameSvc.getBoardgameId(id);

        JsonObjectBuilder builder = Json
                .createObjectBuilder()
                .add("payload", payload);

        // Get the JsonObject object from JsonBuilder
        JsonObject resp = builder.build();

        return ResponseEntity
        .ok(resp.toString());

    }

}
