import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;




public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        String divisaD ="";
        String divisaO ="";
        CurrencyCoin divisa = new CurrencyCoin();
        String  direccion = "https://v6.exchangerate-api.com/v6/84b6f9581c21eee8a0063247/latest/USD";

        while (true){
            System.out.println("""
                    ***********************************************************************************
                    Sea Bienvenidd@ al conversor de Moneda =\n
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    ***********************************************************************************
                    Elija una opción Válida:
                    """);
            int numeroElegido = lectura.nextInt();

            try {
                URL url = new URL(direccion);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
                JsonObject jsonobj = root.getAsJsonObject();

                JsonObject req_result = jsonobj.getAsJsonObject("conversion_rates");

                if (numeroElegido == 1){
                    System.out.println("Elige la cantidad a cambiar");
                    int cantidad = lectura.nextInt();
                    divisa.setDivisaNombreOrigen("USD");
                    divisa.setDivisaNombreDestino("ARS");
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    double divisaOrigen = req_result.get(divisaO).getAsDouble();
                    double divisaDestino = req_result.get(divisaD).getAsDouble();
                    divisa.setCantidadACambiar(cantidad);
                    divisa.setCantidadOrigen(divisaOrigen);
                    divisa.setCantidadDestino(divisaDestino);

                }if (numeroElegido == 2){
                    System.out.println("Elige la cantidad a cambiar");
                    int cantidad = lectura.nextInt();
                    divisa.setDivisaNombreOrigen("ARS");
                    divisa.setDivisaNombreDestino("USD");
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    double divisaOrigen = req_result.get(divisaO).getAsDouble();
                    double divisaDestino = req_result.get(divisaD).getAsDouble();
                    divisa.setCantidadACambiar(cantidad);
                    divisa.setCantidadOrigen(divisaOrigen);
                    divisa.setCantidadDestino(divisaDestino);
                }else if (numeroElegido == 3){
                    System.out.println("Elige la cantidad a cambiar");
                    int cantidad = lectura.nextInt();
                    divisa.setDivisaNombreOrigen("USD");
                    divisa.setDivisaNombreDestino("BRL");
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    double divisaOrigen = req_result.get(divisaO).getAsDouble();
                    double divisaDestino = req_result.get(divisaD).getAsDouble();
                    divisa.setCantidadACambiar(cantidad);
                    divisa.setCantidadOrigen(divisaOrigen);
                    divisa.setCantidadDestino(divisaDestino);
                }else if (numeroElegido == 4){
                    System.out.println("Elige la cantidad a cambiar");
                    int cantidad = lectura.nextInt();
                    divisa.setDivisaNombreOrigen("BRL");
                    divisa.setDivisaNombreDestino("USD");
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    double divisaOrigen = req_result.get(divisaO).getAsDouble();
                    double divisaDestino = req_result.get(divisaD).getAsDouble();
                    divisa.setCantidadACambiar(cantidad);
                    divisa.setCantidadOrigen(divisaOrigen);
                    divisa.setCantidadDestino(divisaDestino);
                }else if (numeroElegido == 5){
                    System.out.println("Elige la cantidad a cambiar");
                    int cantidad = lectura.nextInt();
                    divisa.setDivisaNombreOrigen("USD");
                    divisa.setDivisaNombreDestino("COP");
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    double divisaOrigen = req_result.get(divisaO).getAsDouble();
                    double divisaDestino = req_result.get(divisaD).getAsDouble();
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    divisa.setCantidadACambiar(cantidad);
                    divisa.setCantidadOrigen(divisaOrigen);
                    divisa.setCantidadDestino(divisaDestino);
                }else if (numeroElegido == 6){
                    System.out.println("Elige la cantidad a cambiar");
                    int cantidad = lectura.nextInt();
                    divisa.setDivisaNombreOrigen("COP");
                    divisa.setDivisaNombreDestino("USD");
                    divisaO = divisa.getDivisaNombreOrigen();
                    divisaD = divisa.getDivisaNombreDestino();
                    double divisaOrigen = req_result.get(divisaO).getAsDouble();
                    double divisaDestino = req_result.get(divisaD).getAsDouble();
                    divisa.setCantidadACambiar(cantidad);
                    divisa.setCantidadOrigen(divisaOrigen);
                    divisa.setCantidadDestino(divisaDestino);
                }else if (numeroElegido == 7){
                    break;
                }else if (numeroElegido > 7){
                    System.out.println("No existe esa opción");
                }
                double cantidadCambio = divisa.getCantidadACambiar();
                double cantidadDestino = divisa.getCantidadDestino();
                double cantidaOrigen = divisa.getCantidadOrigen();
                double calculo = (cantidadCambio*cantidadDestino)/cantidaOrigen;

                System.out.println("La valor de: "+ cantidadCambio+ " ["+divisaO+"]"+ " corresponde al valor final de =>>> "+ calculo+ " ["+divisaD+"]" );

            } catch (Exception  e) {
                throw new RuntimeException(e);
            }

        }

    }
}