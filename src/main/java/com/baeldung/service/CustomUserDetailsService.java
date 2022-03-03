package com.baeldung.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baeldung.dao.UsuarioDao;
import com.baeldung.model.Usuario;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuario myUser = this.usuarioDao.getUsuarioByUsuario(username);
			
			if(myUser == null) {
				throw new UsernameNotFoundException(username);
			}
			
			ArrayList<GrantedAuthority> ls = new ArrayList<>();
			
			GrantedAuthority authority = new SimpleGrantedAuthority("User");
			ls.add(authority);
			
			UserDetails userDetails = new User(myUser.getUsuario(), myUser.getPassword(), ls);
			
			return userDetails;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
