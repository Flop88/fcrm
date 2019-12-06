package ru.its67.fcrm.repos;

import org.springframework.data.repository.CrudRepository;
import ru.its67.fcrm.domain.Message;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByClientName(String clientName);
    List<Message> findByOrderActive(String orderActive);

}
