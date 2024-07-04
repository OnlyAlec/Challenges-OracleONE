

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Conversor {
    private List<Conversion> transaccion = new ArrayList<>();

    public Conversion obtenerConversion(String inicio, String destino, double monto) throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String apiKey =  dotenv.get("API_KEY");
        URI urlAPI = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + inicio + "/" + destino + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(urlAPI).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Conversion result = new Gson().fromJson(response.body(), Conversion.class);

        transaccion.add(result);

        return result;
    }

    public void muestraTransacciones(){
        int i = 1;

        if (transaccion.isEmpty()) {
            System.out.println("No hay transacciones!");
            return;
        }

        for (Conversion c : transaccion){
            System.out.printf("%s) %s%n",i,c.toStringSimple());
            i++;
        }
    }
}
