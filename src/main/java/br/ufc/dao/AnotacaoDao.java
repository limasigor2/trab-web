package br.ufc.dao;

import java.util.List;

import br.ufc.model.Anotacao;

public interface AnotacaoDao {
	
	public void insereAnotacao(Anotacao anotacao);
	public List<Anotacao> getList();
	public Anotacao getAnotacao(Integer id);
	public void alteraAnotacao(Anotacao anotacao);
	public void removeAnotacao(Anotacao anotacao);
	public boolean existeAnotacao(Anotacao anotacao);
}
