package com.custcoding.estaleiromavingue.App.infra.security;

import io.swagger.v3.oas.models.PathItem;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfigurations {

    private final SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize

                        // Auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/auth/register").permitAll()



                        // Products
                        .requestMatchers(HttpMethod.GET, "/api/product/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/product").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/product/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/product/**").hasRole("ADMIN")


                        // Address

                        .requestMatchers(HttpMethod.GET, "/api/address/**").hasAnyRole(
                                "ADMIN", "OWNER" , "STUFF")
                        .requestMatchers(HttpMethod.POST, "/api/address").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF"
                        )
                        .requestMatchers(HttpMethod.PUT,"/api/address/**").hasAnyRole(
                                "ADMIN", "OWNER" , "STUFF"
                        )
                        .requestMatchers(HttpMethod.DELETE,"/api/address/**").hasAnyRole(
                                "ADMIN", "OWNER" , "STUFF"
                        )

                        //  Customer

                        .requestMatchers(HttpMethod.GET, "/api/customer").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.GET, "/api/customer/{id}").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.POST, "/api/customer").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.PUT, "/api/customer/**").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.DELETE, "/api/customer/**").hasRole(
                                "ADMIN")

                        // Customer Water

                        .requestMatchers(HttpMethod.GET, "/api/customer-water").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.GET, "/api/customer-water/{id}").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.POST, "/api/customer-water").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.PUT, "/api/customer-water/**").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.DELETE, "/api/customer-water/**").hasRole(
                                "ADMIN")

                        // Ferragem
                        .requestMatchers(HttpMethod.GET, "/api/ferragem/**").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF", "CUSTOMER", "CUSTOMER_WATER")
                        .requestMatchers(HttpMethod.POST, "/api/ferragem").hasAnyRole(
                                "ADMIN", "OWNER")
                        .requestMatchers(HttpMethod.PUT, "/api/ferragem/**").hasAnyRole(
                                "ADMIN", "OWNER")
                        .requestMatchers(HttpMethod.DELETE, "/api/ferragem/**").hasRole(
                                "ADMIN")

                        // Owner
                        .requestMatchers(HttpMethod.GET, "/api/owner").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.GET, "/api/owner/{id}").hasAnyRole(
                                "ADMIN", "OWNER", "STUFF")
                        .requestMatchers(HttpMethod.POST, "/api/owner").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/owner/**").hasAnyRole(
                                "ADMIN", "OWNER")
                        .requestMatchers(HttpMethod.DELETE, "/api/owner/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
