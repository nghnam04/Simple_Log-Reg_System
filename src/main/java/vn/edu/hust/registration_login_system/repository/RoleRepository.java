package vn.edu.hust.registration_login_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.hust.registration_login_system.constant.RoleEnum;
import vn.edu.hust.registration_login_system.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleEnum name);
}
