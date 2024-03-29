package br.com.conexao.dao;

import javax.persistence.EntityManager;

import br.com.conexao.beans.Produto;
import br.com.conexao.exception.IdNaoEncontrado;

public class ProdutoDao2 implements PodutoDAO {

	private EntityManager em;
	
	public ProdutoDao2(EntityManager em) {
		this.em = em;
	}

	public Produto buscarPorId(int id) throws IdNaoEncontrado {
		Produto produto = em.find(Produto.class, id);
		if (produto == null)
			throw new IdNaoEncontrado("Produto não encontrado");
		return produto;
	}

}
