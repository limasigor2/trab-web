package br.ufc.dao;

import java.util.List;

import br.ufc.model.Usuario;

public interface UsuarioDao {
	public void adiciona(Usuario usuario);
	
	public List<Usuario> getLista();

	public Usuario getUsuario(Integer id);

	public void altera(Usuario usuario);

	public void remove(Usuario usuario);

	public boolean existeUsuario(Usuario usuario);
}

