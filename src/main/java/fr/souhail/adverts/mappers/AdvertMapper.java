package fr.souhail.adverts.mappers;

import fr.souhail.adverts.dto.AdvertDto;
import fr.souhail.adverts.entities.Advert;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdvertMapper {

    AdvertMapper INSTANCE = Mappers.getMapper(AdvertMapper.class);


    Advert advertDtoToAdvert(AdvertDto advertDto);

}
