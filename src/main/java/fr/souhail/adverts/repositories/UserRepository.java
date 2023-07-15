package fr.souhail.adverts.repositories;

import fr.souhail.adverts.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email);

}
