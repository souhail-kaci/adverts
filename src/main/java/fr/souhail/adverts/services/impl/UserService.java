package fr.souhail.adverts.services.impl;

import fr.souhail.adverts.dto.UserDto;
import fr.souhail.adverts.entities.PasswordResetToken;
import fr.souhail.adverts.entities.Role;
import fr.souhail.adverts.entities.User;
import fr.souhail.adverts.exceptions.UserNotFoundException;
import fr.souhail.adverts.mappers.UserMapper;
import fr.souhail.adverts.repositories.PasswordResetTokenRepository;
import fr.souhail.adverts.repositories.RoleRepository;
import fr.souhail.adverts.repositories.UserRepository;
import fr.souhail.adverts.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static fr.souhail.adverts.configuration.security.Permission.GUEST;

@Service
@Transactional
public class UserService implements IUserService {


    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    private final RoleRepository roleRepository;

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    private final JavaMailSender javaMailSender;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, PasswordResetTokenRepository passwordResetTokenRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.findByEmailIgnoreCase(email);
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

    @Override
    public void handleForgotPasswordRequest(String email, String contextPath) {

        //FIND USER BY EMAIL
        User userByEmail = this.getUserByEmail(email);

        if (userByEmail == null) {
            throw new UserNotFoundException("User not found");
        }


        PasswordResetToken passwordResetToken = this.getPasswordResetTokenForUser(userByEmail);

        //SAVE TOKEN TO BDD

        this.passwordResetTokenRepository.save(passwordResetToken);


        //GET MAIL CONTEXT
        SimpleMailMessage message = this.getMessage(email, contextPath, passwordResetToken.getToken());

        //SEND MAL TO USER
        this.javaMailSender.send(message);


    }


    private PasswordResetToken getPasswordResetTokenForUser(User user) {

        var passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUser(user);

        String token = UUID.randomUUID().toString();

        LocalDateTime localDateTime = LocalDateTime.now().plusHours(8);

        passwordResetToken.setToken(token);
        passwordResetToken.setExpireDateTime(localDateTime);

        return passwordResetToken;

    }

    private SimpleMailMessage getMessage(String mail, String contextPath, String token) {

        var message = new SimpleMailMessage();
        message.setFrom("souhail.kacimi98@gmail.com");
        message.setTo(mail);
        message.setSubject("Forget Password");
        message.setText("Please connect to this url to reset your password : " +
                contextPath + "/reset?token=" + token);

        return message;
    }
}
