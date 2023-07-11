package fr.souhail.adverts.mappers;

import fr.souhail.adverts.dto.UserDto;
import fr.souhail.adverts.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    @Mapping(target = "password",ignore = true)
    User userDtoToUser(UserDto userDto);


}
