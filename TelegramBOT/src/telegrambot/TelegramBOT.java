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
        Condivisa c = Condivisa.getInstance();
        c.users = c.gf.loadLocations(Condivisa.PATH);
        GestoreMessaggi gm = new GestoreMessaggi();
        gm.start();
        ThreadUpdate tup = new ThreadUpdate();
        tup.start();

    }

}
