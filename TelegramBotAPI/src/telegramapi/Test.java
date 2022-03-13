/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramapi;

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
import java.util.List;
import org.json.*;

/**
 *
 * @author marelli_samuele
 */
public class Test {

    public void Hello() {
        System.out.println("Hello World");
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

    public List<Message> getUpdate(int last_update_id) throws IOException {
        List<Message> results = null;
        String jsonString = readJsonFromUrl("https://api.telegram.org/bot5219437388:AAG7PWHCynCCK5jGtEmeUpy6j6s1W-sI4ls/getUpdates?offset=" + last_update_id);
        if (!jsonString.equals("")) {
            JSONObject obj = new JSONObject(jsonString);
            boolean ok = obj.getBoolean("ok");
            if (ok) {
                results = new ArrayList<Message>();
                JSONArray arr = obj.getJSONArray("result");
                for (int i = 0; i < arr.length(); i++) {
                    Message m = new Message();
                    int update_id = arr.getJSONObject(i).getInt("update_id");
                    JSONObject message = arr.getJSONObject(i).getJSONObject("message");
                    int message_id = message.getInt("message_id");
                    JSONObject from = message.getJSONObject("from");
                    Utente p_from = Utente.elaborateJSONObject(from);
                    JSONObject chat = message.getJSONObject("chat");
                    Chat p_chat = Chat.elaborateJSONObject(chat);
                    int date = message.getInt("date");
                    String text = message.getString("text");
                    m.chat = p_chat;
                    m.from = p_from;
                    m.update_id = update_id;
                    m.message_id = message_id;
                    m.date = date;
                    m.text = text;
                    results.add(m);
                }
              //URL url = new URL("https://api.telegram.org/bot5219437388:AAG7PWHCynCCK5jGtEmeUpy6j6s1W-sI4ls/getUpdates?offset=" + results.get(results.size()-1).update_id);
            }
        }
        return results;
    }

    public boolean sendMessage(int chat_id, String text) throws IOException {
        String encode_txt = URLEncoder.encode(text, "UTF-8");
        String jsonString = readJsonFromUrl("https://api.telegram.org/bot5219437388:AAG7PWHCynCCK5jGtEmeUpy6j6s1W-sI4ls/sendMessage?chat_id=" + chat_id + "&text=" + encode_txt);
        if (!jsonString.equals("")) {
            JSONObject obj = new JSONObject(jsonString);
            boolean ok = obj.getBoolean("ok");
            if (ok) {
                return true;
            }
        }
        return false;
    }
}
