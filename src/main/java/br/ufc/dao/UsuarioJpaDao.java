package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Usuario;
@Repository
@Primary
public class UsuarioJpaDao implements UsuarioDao{

	@Autowired
	private EntityManager em;
	@Override
	@Transactional
	public void adiciona(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> getLista() {
		List<Usuario> resultado = em.createQuery("from usuario", Usuario.class).getResultList();
		return resultado;
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario getUsuario(Integer id) {
		return em.find(Usuario.class, id);
	}


	@Override
	@Transactional
	public void altera(Usuario usuario) {
		em.merge(usuario);
	}


	@Override
	@Transactional
	public void remove(Usuario usuario) {
		em.remove(em.merge(usuario));
	}

	@Override
	@Transactional
	public boolean existeUsuario(Usuario usuario) {
		
		Usuario usuarioLogin = null; 
		try{
			usuarioLogin = (Usuario) em.createQuery("select u from usuario u "
					+ "where u.login = :login and u.senha = :senha")
					.setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha())
					.getSingleResult();

		}catch(Exception e){
			e.printStackTrace();
		}

		if(usuarioLogin == null){
			return false;
		}
		else{
			return true;
		}
	}

}
