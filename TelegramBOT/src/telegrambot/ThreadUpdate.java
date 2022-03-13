/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramapi.*;
import telegramapi.Message;
import org.json.*;

/**
 *
 * @author marelli_samuele
 */
public class ThreadUpdate extends Thread {

    Condivisa c;

    public ThreadUpdate() {
        c = Condivisa.getInstance();
    }

    public ThreadUpdate(Condivisa c) {
        this.c = c;
    }

    @Override
    public void run() {
        Test t = new Test();
        int size = 0;
        int last_update_id=-1;
        while (true) {
            try {
                try {
                    c.results.addAll(t.getUpdate(last_update_id));                    
                    if (c.results != null && c.results.size() > 0) {                        
                        size = c.results.size();
                        Message m;
                        m = c.results.get(c.results.size() - 1);
                        last_update_id = m.getUpdate_id() + 1;
//                        t.sendMessage(m.getChat().getId(), m.getText());

                    }
                } catch (IOException ex) {
                    Logger.getLogger(ThreadUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
