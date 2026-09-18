package com.task1.task57.controller;

//Implement the following 4 APIs:
//Save Player done
//Update Player done
//Get Player By ID done
//Delete Player done


import com.task1.task57.model.Player;
import com.task1.task57.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PutMapping("/update/{id}")
    public Player updatePlayer(
            @PathVariable Long id,
            @RequestBody Player player) {

        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.RemovePlayer(id);
    }


    @PostMapping("/Post")
    public Player savePlayer(@RequestBody Player player) {
       return playerService.savePlayer(player);
    }


    @GetMapping("/Get/{id}")
    public Player getPlayerById(@PathVariable Long id) {

        return  playerService.getPlayer(id);

    }

}


