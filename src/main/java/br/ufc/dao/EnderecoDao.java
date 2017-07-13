package br.ufc.dao;

import java.util.List;

import br.ufc.model.Endereco;

public interface EnderecoDao {
	public void insereEndereco(Endereco endereco);
	public List<Endereco> getList();
	public Endereco getEndereco(Integer id);
	public void alteraAnotacao(Endereco endereco);
	public void removeEndereco(Endereco endereco);
	public boolean existeEndereco(Endereco endereco);
}
