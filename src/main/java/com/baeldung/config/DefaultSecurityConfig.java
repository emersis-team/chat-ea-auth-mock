package com.baeldung.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class DefaultSecurityConfig {
//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
          authorizeRequests.anyRequest().authenticated()
        )
          .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService users() {
        UserDetails user = User.withDefaultPasswordEncoder()
          .username("admin")
          .password("password")
          .roles("USER")
          .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        InMemoryUserDetailsManager memory = new InMemoryUserDetailsManager();
        memory.createUser(user);
        memory.createUser(user2);
        return memory;
    }
    
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//    	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//    	auth.setUserDetailsService(customUserDetailsService);
//    	auth.setPasswordEncoder(passwordEncoder());
//    	return auth;
//    }
//    
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//    	return encoder;
//    }
    
}
