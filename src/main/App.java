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

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		byte optionResource = 0;
		byte optionId = 0;
		Request reqGet = null;
		
		//Menu para selecionar recursos
		System.out.println("===========================");
		System.out.println("Selecione qual dos recursos");
		System.out.println("   voc� deseja procurar:   ");
		System.out.println("---------------------------");
		System.out.println("        1 para posts       ");
		System.out.println("      2 para comments      ");
		System.out.println("       3 para albums       ");
		System.out.println("       4 para photos       ");
		System.out.println("        5 para todos       ");
		System.out.println("        6 para users       ");
		System.out.println("===========================\n");
		
		System.out.print("Op��o: ");
		optionResource = scanner.nextByte();
		
		System.out.print("Digite o ID que deseja visualizar: ");
		optionId = scanner.nextByte();
		
		switch(optionResource) {
			case 1:
				reqGet = new Request("https://jsonplaceholder.typicode.com/posts/" + optionId);
				break;
			case 2:
				reqGet = new Request("https://jsonplaceholder.typicode.com/comments/" + optionId);
				break;
			case 3:
				reqGet = new Request("https://jsonplaceholder.typicode.com/albums/" + optionId);
				break;
			case 4:
				reqGet = new Request("https://jsonplaceholder.typicode.com/photos/" + optionId);
				break;
			case 5:
				reqGet = new Request("https://jsonplaceholder.typicode.com/todos/" + optionId);
				break;
			case 6:
				reqGet = new Request("https://jsonplaceholder.typicode.com/users/" + optionId);
				break;
			default:
				System.out.println("Comando Inv�lido!");
				break;
		}
		
		reqGet.requestGet();
		
		scanner.close();

	}

}
