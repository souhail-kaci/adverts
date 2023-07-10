package fr.souhail.adverts.services.impl;

import fr.souhail.adverts.entities.User;
import fr.souhail.adverts.exceptions.UserNotFoundException;
import fr.souhail.adverts.repositories.UserRepository;
import fr.souhail.adverts.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
