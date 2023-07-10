package fr.souhail.adverts.controllers;


import fr.souhail.adverts.dto.CreateUserFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new CreateUserFormDto());
        return "create-user";
    }


    @PostMapping("/sign-up")
    public String saveUser(@Valid @ModelAttribute("user") CreateUserFormDto userInfos,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "create-user";
        }

        return "login";
    }

}
