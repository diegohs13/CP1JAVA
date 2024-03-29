package br.com.conexao.beans;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {
   Socket socket;

   public void comunicarComServidor() throws Exception {
       String textoRequisicao = "Conexao estabelecida";
       String textoRecebido = "";
       socket = new Socket("localhost", 12337);

       Scanner input = new Scanner(System.in);
       System.out.print("\nDigite o Id do produto: ");
       textoRequisicao = input.nextLine();
 
       ConexaoTCP.enviar(socket, textoRequisicao);

       textoRecebido = ConexaoTCP.receber(socket);

       System.out.println("Servidor enviou: " + textoRecebido);
   }

   public static void main(String[] args) {
       try {
           Cliente cliente = new Cliente();
           cliente.comunicarComServidor();
       } catch(Exception e){
           e.printStackTrace();
       }
   } 
}
