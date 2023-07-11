package fr.souhail.adverts.controllers;


import fr.souhail.adverts.dto.UserDto;
import fr.souhail.adverts.services.IUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {



    private final AuthenticationProvider authenticationProvider;

    private final IUserService userService;

    public UserController(AuthenticationProvider authenticationProvider, IUserService userService) {
        this.authenticationProvider = authenticationProvider;
        this.userService = userService;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new UserDto());
        return "create-user";
    }


    @PostMapping("/sign-up")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userInfos,
                           BindingResult bindingResult) {

        //CHECK IF FOR ANY ERROR
        if (bindingResult.hasErrors()) {
            return "create-user";
        }


        //SAVE USER
        this.userService.saveUser(userInfos);

        //PREPARE AUTHENTICATION

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(userInfos.getEmail(), userInfos.getPassword());

        //CALL AUTHENTICATION PROVIDER

        Authentication authentication = this.authenticationProvider.authenticate(usernamePasswordAuthenticationToken);

        //SET AUTHENTICATION IN CONTEXT
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return "redirect:/adverts";
    }

}
