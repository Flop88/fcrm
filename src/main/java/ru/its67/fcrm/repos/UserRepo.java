package ru.its67.fcrm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.its67.fcrm.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String code);
}
