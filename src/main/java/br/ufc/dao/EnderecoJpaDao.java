package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Endereco;

public class EnderecoJpaDao implements EnderecoDao {

	@Autowired
	private EntityManager em;

	@Override
	@Transactional
	public void insereEndereco(Endereco endereco) {
		em.persist(endereco);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Endereco> getList() {
		List<Endereco> result = em.createQuery("from enderecos", Endereco.class).getResultList();
		return result;
	}


	@Override
	@Transactional(readOnly=true)
	public Endereco getEndereco(Integer id) {
		return em.find(Endereco.class, id);
	}

	@Override
	@Transactional
	public void alteraAnotacao(Endereco endereco) {
		em.merge(endereco);
	}


	@Override
	@Transactional
	public void removeEndereco(Endereco endereco) {
		em.remove(em.merge(endereco));
		
	}


	@Override
	@Transactional
	public boolean existeEndereco(Endereco endereco) {
		Endereco _endereco = null; 
		try{
			_endereco = (Endereco) em.createQuery("select e from endereco e "
					+ "where u.nomeRua = :nomeRua and u.bairro = :bairro")
					.setParameter("nomeRua", endereco.getNomeRua())
					.setParameter("bairro", endereco.getBairro())
					.getSingleResult();

		}catch(Exception e){
			e.printStackTrace();
		}
		return _endereco != null;
	}

}
