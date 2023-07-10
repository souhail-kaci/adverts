package fr.souhail.adverts.configuration.security;

import fr.souhail.adverts.entities.Role;
import fr.souhail.adverts.entities.User;
import fr.souhail.adverts.exceptions.UserNotFoundException;
import fr.souhail.adverts.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomAuthentificationProvider implements AuthenticationProvider {


    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthentificationProvider(IUserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        //GET USER FROM BDD

        User user = this.userService.getUserByEmail(email);

        //IF USER NOT FOUND
        if (user == null) {
            throw new BadCredentialsException("Bad credential");
        }

        // CHECK IF WRONG PASSWORD
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Bad password");
        }

        //GET AUTHORITY
        Set<GrantedAuthority> authorities = this.getAuthorities(user.getRoles());

        return new UsernamePasswordAuthenticationToken(email,password,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


    private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {

        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toSet());


    }

}
