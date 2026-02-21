package com.custcoding.estaleiromavingue.App.infra.security;

import com.custcoding.estaleiromavingue.App.infra.security.service.TokenService;
import com.custcoding.estaleiromavingue.App.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {


    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException,
            IOException {

        var token = this.recoveryToken(request);

        if (token != null){
            var username = tokenService.validateToken(token);
            UserDetails user = userRepository.findByUsername(username);

            if(!username.isEmpty()) {
                var authentication = new UsernamePasswordAuthenticationToken(
                        user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }else {
                System.out.println("404: "+ username);
            }

        }
        filterChain.doFilter(request, response);

    }

    private String recoveryToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

}
