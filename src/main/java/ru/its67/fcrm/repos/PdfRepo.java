package ru.its67.fcrm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.its67.fcrm.domain.Message;

public interface PdfRepo extends JpaRepository<Message,Integer> {
}