package fr.souhail.adverts.services.impl;

import fr.souhail.adverts.dto.UserDto;
import fr.souhail.adverts.entities.Role;
import fr.souhail.adverts.entities.User;
import fr.souhail.adverts.mappers.UserMapper;
import fr.souhail.adverts.repositories.RoleRepository;
import fr.souhail.adverts.repositories.UserRepository;
import fr.souhail.adverts.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

import static fr.souhail.adverts.configuration.security.Permission.GUEST;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    private final RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public Integer saveUser(UserDto userDto) {

        //MAPPER USER
        User user = UserMapper.INSTANCE.userDtoToUser(userDto);

        //ENCODE PASSWORD
        String encodedPassword = this.passwordEncoder.encode(userDto.getPassword());

        user.setPassword(encodedPassword);


        Role role = this.roleRepository.findByNameIgnoreCase(GUEST.name());


        user.setRoles(Set.of(role));

        //SAVE USER

        this.userRepository.save(user);


        return user.getId();
    }
}
