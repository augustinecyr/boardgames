package com.sg.day17boardgames.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sg.day17boardgames.models.Boardgame;
import com.sg.day17boardgames.services.BoardgameService;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

@RestController
@RequestMapping(path = "/boardgame", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardgameRestController {

    @Autowired
    private BoardgameService boardgameSvc;

    @GetMapping(value = "{gid}")
    public ResponseEntity<String> getBoardgame(@PathVariable String gid) {
        Optional<Boardgame> opt = boardgameSvc.getBoardgameById(gid);

        if (opt.isEmpty()) {
            JsonObject err = Json.createObjectBuilder()
                    .add("error", "Id %s not found".formatted(gid))
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(err.toString());
        }

        Boardgame boardgame = opt.get();
        return ResponseEntity.ok(boardgame.toJson().toString());
    }

}
