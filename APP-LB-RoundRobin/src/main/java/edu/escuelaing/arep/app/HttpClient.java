package edu.escuelaing.arep.app;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HttpClient {
    private String[] ports = {":8001",":8002",":8003"};
    private int nServer = 0;
    private String url = "http://192.168.99.100";

    /**
     * Realiza una petición get al LogService correspondiente.
     * @return String con el body de la petición get que se realizó.
     * @throws UnirestException
     */
    public String getMessage() throws UnirestException {
        HttpResponse<String> apiResponse = Unirest.get(url+ports[nServer]+"/messages").asString();
        System.out.println("Petición GET de "+url+ports[nServer]);
        return apiResponse.getBody();
    }

    /**
     * Realiza una petición post al LogService correspondiente.
     * @param message Mensaje que se quiere ser ingresado en la base de datos.
     * @return String con el body de la petición post que se realizó.
     * @throws UnirestException
     */
    public String postMessage(String message) throws UnirestException {
        HttpResponse<String> apiResponse = Unirest.post(url+ports[nServer]+"/messages")
                .body(message)
                .asString();
        System.out.println("Petición POST de "+url+ports[nServer]);
        return apiResponse.getBody();
    }

    /**
     * Combia el valor de la variable nServer para cambiar entre los tres puertos de los LogService.
     */
    public void changeNumberServer(){
        nServer=(nServer + 1) % ports.length;
    }

}
