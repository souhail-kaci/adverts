package fr.souhail.adverts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdvertController {

    @GetMapping("/adverts")
    public String adverts() {
        return "adverts";
    }

}
