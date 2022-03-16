/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import telegramapi.*;

/**
 *
 * @author marelli_samuele
 */
public class GestoreMessaggi extends Thread {

    Condivisa c;

    public GestoreMessaggi() {
        c = Condivisa.getInstance();
    }

    @Override
    public void run() {
        while (true) {
            c = Condivisa.getInstance();
            if (c.results.size() > 0) {
                Message m = c.results.get(0);
                String text = m.getText();
                String operation = text.strip();
                operation = operation.split(" ")[0];
                switch (operation) {
                    case "/città": {
                        try {
                            String citta = text.substring(7).strip();
                            OpenStreetMaps maps = new OpenStreetMaps();
                            double[] coord = maps.getPosition(citta);
                            if (coord != null) {
                                c.telegramLib.sendMessage(m.getChat().getId(), citta);
                                c.telegramLib.sendLocation(m.getChat().getId(), coord);
                                Utenti user = new Utenti(citta, m.getChat().getId(), coord[0], coord[1]);
                                c.gf.saveLocation("locations.txt", user);
                            }
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(GestoreMessaggi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    default: {
                        try {
                            c.telegramLib.sendMessage(m.getChat().getId(), "Comando non riconosciuto");
                        } catch (IOException ex) {
                            Logger.getLogger(GestoreMessaggi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                }
                c.results.remove(0);

            }
        }
    }

}
