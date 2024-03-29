package br.com.conexao.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.PostPersist;

@Entity
@Table(name = "ESTOQUE")
public class Produto {
	
	   @Id
	   private int id;
	   
	   @Column(name = "nome", length = 50)
	   private String nome;
	   
	   @Column(name = "preco", precision = 4, scale = 2)
	   private double preco;
	   
	   @Column(name = "validade")
	   private String validade;
	   
	   @Column(name = "tamanho", precision = 3)
	   private double tamanho;
	   
	   @Column(name = "descricao", length = 100)
	   private String descricao;
	   
	   public Produto(int id, String nome, double preco, String validade, double tamanho, String descricao) {
	this.id = id;
	       this.nome = nome;
	       this.preco = preco;
	       this.validade = validade;
	       this.tamanho = tamanho;
	       this.descricao = descricao;
	   }
	   
	   public Produto() {
		   
	   }
	   
	   @PostPersist 
		private void executar() {
			System.out.println("Executando o método..");
		}
	   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	   
	}
