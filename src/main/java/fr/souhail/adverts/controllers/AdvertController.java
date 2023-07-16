package fr.souhail.adverts.controllers;

import fr.souhail.adverts.dto.AdvertDto;
import fr.souhail.adverts.entities.Advert;
import fr.souhail.adverts.services.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class AdvertController {


    private final IAdvertService advertService;


    @Autowired
    public AdvertController(IAdvertService iAdvertService) {
        this.advertService = iAdvertService;
    }

    @GetMapping("/adverts")
    public String adverts(Model model) {

        model.addAttribute("adverts", this.advertService.getAllAdvert());

        return "adverts";
    }


    @GetMapping("/add-advert")
    public String Addadvert(Model model) {
        model.addAttribute("advert", new AdvertDto());

        return "add-advert";
    }


    @PostMapping("/add-advert")
    public String handleAddAdvert(@Valid @ModelAttribute(name = "advert") AdvertDto advert,
                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add-advert";
        }


        //ADD ADVERT
        this.advertService.addAdvert(advert);


        //REDIRECT TO ALL ADVERT PAGE
        return "redirect:/adverts";

    }


}
