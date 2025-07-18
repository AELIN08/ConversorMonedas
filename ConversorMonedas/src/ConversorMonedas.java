import java.util.Map;
/**
 * Clase encargada de realizar la conversión entre dos monedas,
 * utilizando las tasas proporcionadas por la API.
 */

public class ConversorMonedas {

    private TasasCambio tasas;// Objeto que contiene las tasas de cambio obtenidas de la API

    //Constructor que inicializa el conversor con las tasas de cambio.
    public ConversorMonedas(TasasCambio tasas) {
        this.tasas = tasas;
    }

    //Realiza la conversión de una cantidad entre dos monedas.
    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        Map<String, Double> valoresConversion = tasas.conversion_rates();// Mapa de todas las tasas

        // Validación: Verificar si ambas monedas están presentes en la respuesta
        boolean origenInvalido = !valoresConversion.containsKey(monedaOrigen);
        boolean destinoInvalido = !valoresConversion.containsKey(monedaDestino);

        if (origenInvalido || destinoInvalido) {
            throw new IllegalArgumentException("Moneda no encontrada en la lista de tasas.");

        }

        double tasaOrigen = valoresConversion.get(monedaOrigen);
        double tasaDestino = valoresConversion.get(monedaDestino);

        // Conversión de la cantidad a la moneda base
        double cantidadEnBase = cantidad / tasaOrigen;

        //Conversion de la base a la moneda destino
        return cantidadEnBase * tasaDestino;

    }



}
