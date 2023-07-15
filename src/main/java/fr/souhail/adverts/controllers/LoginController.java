package fr.souhail.adverts.controllers;


import fr.souhail.adverts.exceptions.UserNotFoundException;
import fr.souhail.adverts.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final String FORGET_PASSWORD_PAGE = "forget-password";


    private final IUserService userService;

    @Autowired
    public LoginController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("error", error);
        }


        return "login";
    }

    @RequestMapping(value = "/forgot-password", method = {RequestMethod.GET, RequestMethod.POST})
    public String forgotPassword(@RequestParam(name = "email", required = false) String email,
                                 Model model,
                                 HttpServletRequest request) {

        if (email == null) {
            return FORGET_PASSWORD_PAGE;
        }

        //HANDLE REQUEST

        try {

            String url = request.getRequestURL().toString().replace("/forgot-password", "");

            this.userService.handleForgotPasswordRequest(email,url );
            model.addAttribute("succes", "An email with reset password info is sent to you");

        } catch (UserNotFoundException e) {
            model.addAttribute("error", "Email not found");
        }

        return FORGET_PASSWORD_PAGE;


    }


}
