import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurrencyCoin  {

    private double cantidadOrigen;
    private double cantidadDestino;
    private double cantidadACambiar;
    private String divisaNombreOrigen;
    private String divisaNombreDestino;
    private String divisaO ="";
    private String divisaD ="";
    private JsonObject req_result;
    private String  direccion = "https://v6.exchangerate-api.com/v6/84b6f9581c21eee8a0063247/latest/USD";

    public String getDivisaO() {
        return divisaO;
    }

    public String getDivisaD() {
        return divisaD;
    }

    public JsonObject getReq_result() {
        return req_result;
    }

    public void setReq_result(JsonObject req_result) {
        this.req_result = req_result;
    }
    public void setDivisaO(String divisaO) {
        this.divisaO = divisaO;
    }

    public void setDivisaD(String divisaD) {
        this.divisaD = divisaD;
    }

    public String getDivisaNombreOrigen() {
        return divisaNombreOrigen;
    }

    public void setDivisaNombreOrigen(String divisaNombreOrigen) {
        this.divisaNombreOrigen = divisaNombreOrigen;
    }

    public String getDivisaNombreDestino() {
        return divisaNombreDestino;
    }

    public void setDivisaNombreDestino(String divisaNombreDestino) {
        this.divisaNombreDestino = divisaNombreDestino;
    }

    public double getCantidadOrigen() {
        return cantidadOrigen;
    }

    public void setCantidadOrigen(double cantidadOrigen) {
        this.cantidadOrigen = cantidadOrigen;
    }

    public double getCantidadDestino() {
        return cantidadDestino;
    }

    public void setCantidadDestino(double cantidadDestino) {
        this.cantidadDestino = cantidadDestino;
    }

    public double getCantidadACambiar() {
        return cantidadACambiar;
    }

    public void setCantidadACambiar(double cantidadACambiar) {
        this.cantidadACambiar = cantidadACambiar;
    }

    public CurrencyCoin() throws IOException {
        URL url = new URL(direccion);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject req_result = jsonobj.getAsJsonObject("conversion_rates");
        setReq_result(req_result);
    }

    public void opciones(int opcion){
        if(opcion > 7){
            System.out.println( "No existe esa opción");
        }

    }


    public void CalculoCambioDivisa(double cambio, String divisaOr, String divisaDes) {
        double divisaOrigen = getReq_result().get(divisaOr).getAsDouble();
        double divisaDestino = getReq_result().get(divisaDes).getAsDouble();
        this.setCantidadDestino(divisaDestino);
        this.setCantidadOrigen(divisaOrigen);
        this.setCantidadACambiar(cambio);
        this.setDivisaO(divisaOr);
        this.setDivisaD(divisaDes);
        double calculo = (getCantidadACambiar()*getCantidadDestino())/getCantidadOrigen();

        System.out.println("La valor de: "+ getCantidadACambiar()+ " ["+divisaOr+"]"+ " corresponde al valor final de =>>> "+ calculo+ " ["+divisaDes+"]" );
    }



}
