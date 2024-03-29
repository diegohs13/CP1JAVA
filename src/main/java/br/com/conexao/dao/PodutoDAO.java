package br.com.conexao.dao;

import br.com.conexao.beans.Produto;
import br.com.conexao.exception.IdNaoEncontrado;

public interface PodutoDAO {

	Produto buscarPorId(int textoRecebido) throws IdNaoEncontrado;
	
	
}
