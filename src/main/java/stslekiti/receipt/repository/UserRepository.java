package stslekiti.receipt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stslekiti.receipt.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);
}
