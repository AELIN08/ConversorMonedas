import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase responsable de conectarse a la API externa de ExchangeRate-API
 * y obtener las tasas de cambio actualizadas para una moneda base específica.
 */

public class ClienteAPI {
    public TasasCambio obtenerTasaCambio(String monedaBase){

        String apikey= ""; // Clave de acceso a la API, Obten la tuya y agregala para su funcionamiento.
        URI direccion = URI.create( "https://v6.exchangerate-api.com/v6/"+apikey+"/latest/"+monedaBase);

        HttpClient client = HttpClient.newHttpClient(); // Cliente HTTP para hacer la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build(); // Construcción de la solicitud HTTP
        try{
            // Enviar solicitud y obtener la respuesta como String
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir el JSON en un objeto TasasCambio usando Gson
            return new Gson().fromJson(response.body(), TasasCambio.class);


        } catch (Exception e) {
            // Si algo falla, lanzar un error claro
            throw new RuntimeException("Error al conectar con la API: " +e.getMessage());
        }
    }
}
