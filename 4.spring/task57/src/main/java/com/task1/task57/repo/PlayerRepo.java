package com.task1.task57.repo;

import com.task1.task57.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepo extends JpaRepository<Player , Long> {
}
