package fr.souhail.adverts.mappers;

import fr.souhail.adverts.dto.UserDto;
import fr.souhail.adverts.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {


    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDtoToUser(UserDto userDto);


}
