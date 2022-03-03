package com.baeldung.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.baeldung.model.Usuario;


@Transactional
@Repository
public class UsuarioDao {
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public List<Usuario> getUsuarios() {
		try {
			return this.em.createQuery("from Usuario", Usuario.class).getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Usuario getUsuarioByUsuario(String usuario) {
		try {
			return this.em.createQuery("from Usuario WHERE usuario =:usuario", Usuario.class)
					.setParameter("usuario", usuario)
					.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
