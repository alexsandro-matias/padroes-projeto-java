package projeto;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CotacaoDollar {

    private static final String API_KEY = "Y00b230ad1dd1fd9e956184fb"; // Substitua com sua chave da API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/00b230ad1dd1fd9e956184fb/latest/USD";
//    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public double retornaCotacaoDeRealParaDollar() {
        try {
            // Cria a URL para a solicitação
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obtém o código de resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lê a resposta da API
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Processa a resposta JSON
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject rates = jsonResponse.getJSONObject("conversion_rates");

                // Exemplo para pegar a cotação do euro
                double dollarParaReal = rates.getDouble("BRL");
                return dollarParaReal;

            } else {
                System.out.println("Falha na requisição GET");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
