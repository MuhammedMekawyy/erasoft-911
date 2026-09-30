package com.lec9task.repo;

import com.lec9task.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepo extends JpaRepository<Mail,Long> {
    List<Mail> findByName(String name);
    List<Mail> findByNameIn(List<String> names);
    List<Mail> findByContent(String content);
}
