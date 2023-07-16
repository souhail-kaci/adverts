package fr.souhail.adverts.services;

import fr.souhail.adverts.dto.AdvertDto;
import fr.souhail.adverts.entities.Advert;

import java.util.List;

public interface IAdvertService {

    void addAdvert(AdvertDto advertDto);

    List<Advert> getAllAdvert();

}
