/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrambot;

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
            for (Message m : c.results) {
                String text = m.getText();
                if(text.contains("/"))
                {
                    String operation = text.strip();
                    operation = operation.split(" ")[0];
                    int i =0;
                }
            }
        }
    }

}
