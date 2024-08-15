package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadWebPage {
    private static String apikey = "1d289011b790cc56f4d7199ae86dcc67";

    public static void main(String[] args) throws MalformedURLException, IOException {
        BufferedReader br = null;
        try {
            String londonWeatherQuery = "https://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=";
            String theURL = londonWeatherQuery + apikey;
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}