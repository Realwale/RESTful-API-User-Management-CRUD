package net.walecode.restfulapiusermanagementcrud.repository;


import net.walecode.restfulapiusermanagementcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
