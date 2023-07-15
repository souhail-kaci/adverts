package fr.souhail.adverts.services;

import fr.souhail.adverts.dto.UserDto;
import fr.souhail.adverts.entities.User;

public interface IUserService {


    User getUserByEmail(String email);


    Integer saveUser(UserDto userDto);

    void handleForgotPasswordRequest(String mail, String contextPath);


}
