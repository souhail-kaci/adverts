package fr.souhail.adverts.configuration.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends OncePerRequestFilter {

    //URLS THAT NOT AUTHORISE TO ACCESS IF USER AUTHENTICATED
    private final List<String> urls = Arrays.asList("/login", "/sign-up");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        //CHECK IF USER ALREADY AUTHENTICATED
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String contextPath = request.getContextPath();

        String relativeURI = request.getRequestURI().replaceFirst(contextPath,"");

        if (authentication != null && authentication.isAuthenticated() && urls.contains(relativeURI)) {
            response.sendRedirect(request.getContextPath() + "/adverts");
            return;
        }


        //OTHERWISE CONTINUE THE FILTER CHAIN

        filterChain.doFilter(request, response);


    }
}
