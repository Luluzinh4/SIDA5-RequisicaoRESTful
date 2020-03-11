/*
 * App.java
 * Data de Criação: 11 Mar 2020
 * Descrição: Classe principal para chamada das classes para realização
 * conexão via protocolo HTTP.
 * Observação: Códigos comentados serão utilizados ou descartados
 * ao decorrer do processo.
 * 
 */

package main;

public class App {

	public static void main(String[] args) {
		
		Request reqGet = new Request("https://jsonplaceholder.typicode.com/users/4");
		reqGet.requestGet();
		
//		Request reqPost = new Request("https://jsonplaceholder.typicode.com/posts");
//		reqPost.requestPost(4);
		
	}

}
