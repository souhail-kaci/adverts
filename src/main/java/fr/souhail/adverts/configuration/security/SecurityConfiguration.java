package fr.souhail.adverts.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests(matcher -> {
                    matcher.antMatchers("/resources/**").permitAll();
                    matcher.antMatchers("/forgot-password").anonymous();
                    matcher.antMatchers("/reset-password").anonymous();
                    matcher.antMatchers("/sign-up").anonymous();
                    matcher.antMatchers("/login").anonymous();
                    matcher.anyRequest().authenticated();
                })
                .formLogin()
                    .loginProcessingUrl("/handle-login")
                    .failureUrl("/login?error=true")
                    .defaultSuccessUrl("/adverts")
                    .usernameParameter("email")
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthentificationProvider);
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }


}
