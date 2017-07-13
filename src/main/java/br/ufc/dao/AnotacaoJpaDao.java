package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.model.Anotacao;
@Repository
@Primary
public class AnotacaoJpaDao implements AnotacaoDao{

	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public void insereAnotacao(Anotacao anotacao) {
		em.persist(anotacao);
	}

	@Transactional
	@Override
	public List<Anotacao> getList() {
		List<Anotacao> result = em.createQuery("from anotacao", Anotacao.class).getResultList();
		return result;
	}

	@Transactional
	@Override
	public Anotacao getAnotacao(Integer id) {
		return em.find(Anotacao.class, id);
	}

	@Transactional
	@Override
	public void alteraAnotacao(Anotacao anotacao) {
		em.merge(anotacao);
	}

	@Transactional
	@Override
	public void removeAnotacao(Anotacao anotacao) {
		em.remove(em.merge(anotacao));
	}

	@Transactional
	@Override
	public boolean existeAnotacao(Anotacao anotacao) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
