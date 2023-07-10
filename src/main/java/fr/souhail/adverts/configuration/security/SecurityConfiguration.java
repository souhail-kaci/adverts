package fr.souhail.adverts.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final CustomAuthentificationProvider customAuthentificationProvider;

    public SecurityConfiguration(CustomAuthentificationProvider customAuthentificationProvider) {
        this.customAuthentificationProvider = customAuthentificationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authenticationProvider(customAuthentificationProvider)
                .authorizeRequests(p -> {
                    p.antMatchers("/resources/**").permitAll();
                    p.antMatchers("/sign-up").permitAll();
                    p.anyRequest().authenticated();
                })
                .formLogin()
                .loginProcessingUrl("/handle-login")
                .usernameParameter("email")
                .loginPage("/login")
                .defaultSuccessUrl("/adverts")
                .permitAll();


    }

}
