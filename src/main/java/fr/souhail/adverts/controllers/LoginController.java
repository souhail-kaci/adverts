package fr.souhail.adverts.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("error", error);
        }

        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(){

        return "forget-password";
    }


}
