package br.com.conexao.beans;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.conexao.dao.ProdutoDao2;
import br.com.conexao.exception.IdNaoEncontrado;

public class Servidor {
   Socket socketClient;
   ServerSocket serversocket;
   
   public String mensagemProduto(int id){
	   
	   Produto prod = null;
	   EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
	   EntityManager em = fabrica.createEntityManager();
		
	   ProdutoDao2 dao = new ProdutoDao2(em);
	   
	   try {
		prod = dao.buscarPorId(id);
	} catch (IdNaoEncontrado e) {
		e.printStackTrace();
	}
	   
	   String resposta = "ID: " + prod.getId() + 
			   			 ", Nome: " + prod.getNome()  + 
			   			 ", Preço: " + prod.getPreco()  + 
			   			 ", Tamanho: " + prod.getTamanho()  + 
			   			 ", Descrição: " + prod.getDescricao()  ;
	   
	   return resposta;
   }

   public boolean connect() {
       try {
           socketClient = serversocket.accept();  
           return true;
       } catch (IOException e) {
           System.err.println("Nao fez conexao " + e.getMessage());
           return false;
       }
   }

   public static void main(String[] args) {
       try {
           Servidor servidor = new Servidor();
           servidor.rodarServidor();
       } catch(Exception e){
           e.printStackTrace();
       }
   } 

   public void rodarServidor() throws Exception {
       String textoRecebido = "";
       String textoEnviado = "Olá, Cliente";
       Scanner input = new Scanner(System.in);

       serversocket = new ServerSocket(12337);
       System.out.println("Servidor iniciado!");

       while(true) {
           if (connect()) {
               textoRecebido = ConexaoTCP.receber(socketClient);
               System.out.println("Cliente enviou: " + textoRecebido.replaceAll("[^0-9]", ""));
               textoEnviado = mensagemProduto(Integer.parseInt(textoRecebido.replaceAll("[^0-9]", "")));

               ConexaoTCP.enviar(socketClient, textoEnviado);
               socketClient.close(); 
           }
       }
   }
}
