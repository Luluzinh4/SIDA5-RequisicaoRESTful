/*
 * App.java
 * Data de Cria��o: 11 Mar 2020
 * Descri��o: Classe principal para chamada das classes para realiza��o
 * conex�o via protocolo HTTP.
 * Observa��o: C�digos comentados ser�o utilizados ou descartados
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
