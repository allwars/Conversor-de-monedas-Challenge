

public class CurrencyCoin {

    private double cantidadOrigen;
    private double cantidadDestino;
    private double cantidadACambiar;
    private String divisaNombreOrigen;
    private String divisaNombreDestino;

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

    String reqCurrency;


    public void CalculoCambioDivisa() {
        System.out.println((getCantidadACambiar()*getCantidadDestino())/getCantidadOrigen());
    }

    /*CurrencyJson cambiarMoneda(String codigoMoneda){

        String  direccion = "https://v6.exchangerate-api.com/v6/84b6f9581c21eee8a0063247/latest/"+ codigoMoneda;

        //String url_str = "https://v6.exchangerate-api.com/v6/84b6f9581c21eee8a0063247/latest/USD";
            try {
                URL url = new URL(direccion);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();



                // Convert to JSON
                //JsonReader jp = new JsonReader();
                JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
                JsonObject jsonobj = root.getAsJsonObject();

// Accessing object
                JsonObject req_result = jsonobj.getAsJsonObject("conversion_rates");
                String reqCurrency = req_result.get(codigoMoneda).getAsString();
                //System.out.println(reqCurrency);


            } catch (Exception  e) {
                throw new RuntimeException(e);
            }
        return new Gson().fromJson(jsonobj, CurrencyJson.class);




    }*/


}
