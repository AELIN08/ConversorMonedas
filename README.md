# 💱 Conversor de Monedas en Java

Una aplicación de consola desarrollada en Java que permite realizar conversiones entre distintas monedas internacionales, utilizando datos en tiempo real proporcionados por la API de [ExchangeRate-API](https://www.exchangerate-api.com).

Este proyecto es ideal para practicar el consumo de APIs, manejo de JSON con Gson, y aplicar principios de programación orientada a objetos en Java.

---

## 📌 Funcionalidades

- Conversión de monedas en tiempo real.
- Interfaz por consola amigable.
- Manejo de errores ante opciones inválidas o monedas no soportadas.
- Modularidad y separación clara entre clases.

---

## 🧱 Estructura de Clases

| Clase              | Función principal |
|--------------------|-------------------|
| `Main`             | Clase principal. Inicia el programa mostrando el menú. |
| `MenuConversor`    | Muestra un menú interactivo en consola, capta entrada del usuario y gestiona las conversiones. |
| `ClienteAPI`       | Realiza la conexión con la API externa para obtener tasas de cambio. |
| `TasasCambio`      | Clase `record` que representa la respuesta JSON de la API (moneda base y tasas de conversión). |
| `ConversorMonedas` | Contiene la lógica para convertir entre dos monedas usando las tasas de cambio proporcionadas. |

---

## 💻 Tecnologías Usadas

- Java 17+
- [Gson](https://github.com/google/gson) para parseo de JSON
- API pública de [ExchangeRate-API](https://www.exchangerate-api.com)
- `HttpClient` de Java para realizar peticiones HTTP

---

## 🌎 Monedas Soportadas en el Menú

Actualmente puedes realizar conversiones entre:

- MXN — Peso mexicano
- CNY — Yuan (China)
- KRW — Won (Corea del Sur)
- JPY — Yen (Japón)

Se pueden agregar más fácilmente editando la clase `MenuConversor`.

---

## 🔒 Notas Importantes

- Requiere conexión a internet para acceder a la API.
- La clave de la API está definida en la clase `ClienteAPI`. Puedes obtener la tuya gratuita desde [ExchangeRate-API](https://www.exchangerate-api.com/).
- El programa utiliza tasas de cambio con base en MXN, pero es adaptable.

---

### 🎓 Challenge - Alura Latam | Oracle Next Education

Este conversor de monedas fue desarrollado como parte del **Challenge de Java Orientado a Objetos** del programa [**ONE - Oracle Next Education**] en colaboración con [**Alura Latam**].

💡 El objetivo del reto fue aplicar conocimientos adquiridos sobre:
- Java básico y orientado a objetos
- Consumo de APIs con `HttpClient`
- Manipulación de JSON con la biblioteca `Gson`
- Diseño de menús interactivos por consola
- Buenas prácticas de programación

🛠️ **Este proyecto fue de mi autoria [Evelin Mondragon], como parte de mi formación en el programa ONE.**


