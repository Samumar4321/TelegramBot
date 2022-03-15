/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegrambot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import telegramapi.Chat;
import telegramapi.Message;
import static telegramapi.Test.readJsonFromUrl;
import telegramapi.Utente;

/**
 *
 * @author samum
 */
public class OpenStreetMaps {

    String path;

    public OpenStreetMaps() {
    }

    public OpenStreetMaps(String path) {
        this.path = path;
    }

    public double[] getPosition(String citta) throws IOException {
        citta = URLEncoder.encode(citta, "UTF-8");
        double[] coord = null;
        String jsonString = readJsonFromUrl("https://nominatim.openstreetmap.org/search?q=" + citta + "&format=json&addressdetails=1");
        if (!jsonString.equals("")) {
            JSONArray arr = new JSONArray(jsonString);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                if (obj.has("type")) {
                    if (obj.get("type").equals("administrative")) {
                        coord = new double[2];
                        coord[0] = obj.getDouble("lat");
                        coord[1] = obj.getDouble("lon");
                        break;
                    }
                }

            }

        }
        return coord;

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static String readJsonFromUrl(String url) throws IOException, JSONException, FileNotFoundException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        } finally {
            is.close();
        }
    }
}
