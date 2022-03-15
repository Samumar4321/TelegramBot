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
    private static Condivisa instance;

    private Condivisa() {
        results = new ArrayList<Message>();
        telegramLib = new Test();
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

}
