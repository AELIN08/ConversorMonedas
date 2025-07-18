import java.util.Map;

/**
 * Representa la estructura de respuesta de la API de tasas de cambio.
 * Esta clase es un record de Java, que permite almacenar datos inmutables
 * de manera concisa.
 *
 * Contiene:
 * - result: estado de la respuesta de la API (por ejemplo, "success").
 * - base_code: código de la moneda base utilizada para la conversión.
 * - conversion_rates: mapa de códigos de moneda con su tasa de cambio respecto a la base.
 */

public record TasasCambio (String result,
                          String base_code,
                          Map<String, Double> conversion_rates
                          ){
}
