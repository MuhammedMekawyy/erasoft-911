package com.task1.task57.service.serviceImpl;

import com.task1.task57.model.Player;
import com.task1.task57.repo.PlayerRepo;
import com.task1.task57.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepo playerRepo;

    @Autowired
    public PlayerServiceImpl(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    public Player getPlayer(Long id) {
        if (!playerRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Player with id " + id + " not found"
            );
        }
        return playerRepo.getReferenceById(id);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepo.save(player);
    }

    @Override
    public void RemovePlayer(Long id) {

        if (!playerRepo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Player with id " + id + " not found"
            );
        }

        playerRepo.deleteById(id);
    }

    @Override
    public Player updatePlayer(Long id, Player player) {

        Player existingPlayer = playerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Player with id " + id + " not found"
                ));

        existingPlayer.setName(player.getName());
        existingPlayer.setNumber(player.getNumber());
        existingPlayer.setSalary(player.getSalary());

        return playerRepo.save(existingPlayer);
    }
}
