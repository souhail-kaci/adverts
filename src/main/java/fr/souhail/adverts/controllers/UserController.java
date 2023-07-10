package fr.souhail.adverts.controllers;


import fr.souhail.adverts.dto.CreateUserFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new CreateUserFormDto());
        return "create-user";
    }
}
