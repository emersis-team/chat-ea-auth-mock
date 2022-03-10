//package com.baeldung.config;
//
//import java.util.ArrayList;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserDetails details = null;
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		if(username.equals("admin")) {
//			ArrayList<GrantedAuthority> ls = new ArrayList<>();
//			
//			GrantedAuthority authority = new SimpleGrantedAuthority("User");
//			ls.add(authority);
//			
//			details = new User(username, encoder.encode("password"), ls);
//		}else if(username.equals("user")) {
//			ArrayList<GrantedAuthority> ls = new ArrayList<>();
//			
//			GrantedAuthority authority = new SimpleGrantedAuthority("User");
//			ls.add(authority);
//			
//			details = new User(username, encoder.encode("password"), ls);
//		}
//		
//		return details;
//	}
//}
