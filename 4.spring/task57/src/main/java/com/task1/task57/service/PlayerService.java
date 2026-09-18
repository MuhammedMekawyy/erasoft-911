package com.task1.task57.service;

import com.task1.task57.model.Player;


import java.util.List;


public interface PlayerService {
    public Player getPlayer(Long id);
    public Player savePlayer(Player player);
    public void RemovePlayer(Long id);
    public Player updatePlayer(Long id, Player player);
}
