/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import telegramapi.*;
import telegramapi.Message;
import org.json.*;

/**
 *
 * @author marelli_samuele
 */
public class TelegramBOT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Test t = new Test();
        List<Message> results = new ArrayList<Message>();
        results = t.getUpdate();
        if (results != null) {
            Message m;
            m = results.get(results.size() - 1);
            t.sendMessage(m.getChat().getId(), m.getText());
        }
    }

}
