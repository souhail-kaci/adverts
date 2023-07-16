package fr.souhail.adverts.services.impl;

import fr.souhail.adverts.dto.AdvertDto;
import fr.souhail.adverts.entities.Advert;
import fr.souhail.adverts.mappers.AdvertMapper;
import fr.souhail.adverts.repositories.AdvertRepository;
import fr.souhail.adverts.services.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdvertService implements IAdvertService {

    private final AdvertRepository advertRepository;


    @Autowired
    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @Override
    public void addAdvert(AdvertDto advertDto) {

        Advert advert = AdvertMapper.INSTANCE.advertDtoToAdvert(advertDto);

        this.advertRepository.save(advert);


    }

    @Override
    public List<Advert> getAllAdvert() {
        return this.advertRepository.findAll();
    }
}
