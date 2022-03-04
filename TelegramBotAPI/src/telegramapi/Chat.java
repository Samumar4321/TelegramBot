/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramapi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.*;
/**
 *
 * @author marelli_samuele
 */
public class Chat {

    int id;
    String first_name;
    String username;
    String type;

    public Chat() {
        this.id = 0;
        this.first_name = "";
        this.username = "";
        this.type = "";
    }

    public Chat(int id, String first_name, String username, String type) {
        this.id = id;
        this.first_name = first_name;
        this.username = username;
        this.type = type;
    }
    
    static public Chat elaborateJSONObject(JSONObject object)
    {
        Chat chat = new Chat();
        chat.id = object.getInt("id");
        chat.first_name = object.getString("first_name");
        chat.username = object.getString("username");
        chat.type = object.getString("type");
        return chat;
    }

}
