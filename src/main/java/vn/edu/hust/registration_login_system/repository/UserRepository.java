package vn.edu.hust.registration_login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hust.registration_login_system.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    User findByEmail(String email);
}
