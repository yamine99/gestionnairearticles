package fr.ensup.webapp.service;
import fr.ensup.webapp.model.User;
import fr.ensup.webapp.repository.ArticleRepository;

import fr.ensup.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
     @Autowired
     private UserRepository repo;

       public void save(User user){
       repo.save(user);
    }




}
