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
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Request {
	
	private String url;
	private String resposta = "";
	
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
                resposta += linha;
            }

            System.out.println("Status 200 - OK");
            System.out.println(resposta);
            
            conn.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void requestPost(int numero) {
		try {
//			String ehPrimo = "N�o";
//			if (ehPrimo(numero)) {
//				ehPrimo = "Sim";
//			}

	        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Context-type", "application/json");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setDoOutput(true);
	        
	        //String jsonInputString = "{\"Name\": \"Requisi��o Metodo POST\","
	        //						+ " \"ValorInserido\": " + numero + ","
	        //						+ " \"NumeroPrimo\": " + ehPrimo + "}";
	        
	        String json = "{userId: 3,"
	        		   	 + "title: Teste Metodo POST,"
	        		   	 + "body: Teste XPTO}";

//	        try(OutputStream os = conn.getOutputStream()) {
//                byte[] input = jsonInputString.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
	        try(OutputStream os = conn.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }catch (Exception e){
                e.printStackTrace();
            }

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            } catch(Exception e) {
            	e.printStackTrace();
            }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no m�todo POST");
		}
	}
	
	
	//M�todos Auxiliares
	public boolean ehPrimo(int numero) {
	    for (int i = 2; i < numero; i++) {
	        if (numero % i == 0)
	            return false;   
	    }
	    return true;
	}

	
	//Getters e Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getResponse() {
		return resposta;
	}

	public void setResponse(String response) {
		this.resposta = response;
	}
	
}
