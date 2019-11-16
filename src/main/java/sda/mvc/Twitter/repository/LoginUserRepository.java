package sda.mvc.Twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.mvc.Twitter.model.entity.LoginUser;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    Long countByLogin (String login);
}

