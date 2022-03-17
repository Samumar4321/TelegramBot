/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import telegramapi.Message;
import telegramapi.Test;

/**
 *
 * @author marelli_samuele
 */
public class Condivisa {

    List<Message> results;
    Test telegramLib;
    GestoreFIle gf;
    private static Condivisa instance;
    public static String PATH = "locations.txt";
    List<Utenti> users;

    private Condivisa() {
        results = new ArrayList<Message>();
        users = new ArrayList<Utenti>();
        telegramLib = new Test();
        gf = new GestoreFIle();
    }

    public static Condivisa getInstance() {
        if (instance == null) {
            synchronized (Condivisa.class) {
                if (instance == null) {
                    instance = new Condivisa();
                }
            }
        }
        return instance;
    }

    public boolean checkDouplicate(Utenti u) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id_chat == u.id_chat) {
                users.remove(i);
                users.add(u);
                return true;
            }
        }
        return false;
    }

}
