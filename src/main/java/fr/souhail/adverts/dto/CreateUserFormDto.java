package fr.souhail.adverts.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class CreateUserFormDto {


    @NotBlank(message = "Le mot de passe est obligatoire")
    String password;
    @NotBlank(message = "Le prénom est obligatoire")
    String firstName;
    @NotBlank(message = "Le nom est obligatoire")
    String lastName;
    @NotBlank(message = "Email est obligatoire")
    @Email(message = "Veuillez respecter le format d'un email xxxx@xxx.com")
    String email;


}
