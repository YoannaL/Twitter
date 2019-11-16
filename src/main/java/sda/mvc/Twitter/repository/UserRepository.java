package sda.mvc.Twitter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sda.mvc.Twitter.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
