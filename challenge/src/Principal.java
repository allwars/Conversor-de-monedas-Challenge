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
        divisa.opciones(numeroElegido);
            if (numeroElegido == 1){
                System.out.println("Elige la cantidad a cambiar");
                int cantidad = lectura.nextInt();
                divisa.CalculoCambioDivisa(cantidad,"USD","ARS");
            }else if (numeroElegido == 2){
                System.out.println("Elige la cantidad a cambiar");
                int cantidad = lectura.nextInt();
                divisa.CalculoCambioDivisa(cantidad,"ARS","USD");
            }else if (numeroElegido == 3){
                System.out.println("Elige la cantidad a cambiar");
                int cantidad = lectura.nextInt();
                divisa.CalculoCambioDivisa(cantidad,"USD","BRL");
            }else if (numeroElegido == 4){
                System.out.println("Elige la cantidad a cambiar");
                int cantidad = lectura.nextInt();
                divisa.CalculoCambioDivisa(cantidad,"BRL","USD");
            }else if (numeroElegido == 5){
                System.out.println("Elige la cantidad a cambiar");
                int cantidad = lectura.nextInt();
                divisa.CalculoCambioDivisa(cantidad,"USD","COP");
            }else if (numeroElegido == 6){
                System.out.println("Elige la cantidad a cambiar");
                int cantidad = lectura.nextInt();
                divisa.CalculoCambioDivisa(cantidad,"COP","USD");
            }else if (numeroElegido == 7){
                break;
            }else if (numeroElegido > 7){
                System.out.println("No existe esa opción");
            }
        }

    }
}