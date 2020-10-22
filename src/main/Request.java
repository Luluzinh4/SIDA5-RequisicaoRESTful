/* 
 * Request.java
 * Data de Cria��o: 11 Mar 2020
 * Descri��o: Classe Request com os m�todos de GET e POST.
 * Observa��o: C�digos comentados ser�o utilizados ou descartados
 * ao decorrer do processo.
 * 
 */

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {
	private String url;

	//Construtor
	public Request(String url) {
		this.url = url;
	}
	
	
	//M�todos de Requisi��o - Protocolo HTTP
	public void requestGet() {
		try {
            String linha;

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            while ((linha = br.readLine()) != null) {
            	System.out.println(linha);
            }

//            System.out.println("Status 200 - OK");
            
            conn.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
	}

	
	//Getters e Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
