package fr.ensup.webapp.repository;

import fr.ensup.webapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

