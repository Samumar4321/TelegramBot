/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramapi;

/**
 *
 * @author marelli_samuele
 */
public class Message {

    Persona from;
    Chat chat;
    int message_id;
    String text;
    int date;
    int update_id;

    public Message() {
        this.from = null;
        this.chat = null;
        this.message_id = 0;
        this.text = "";
        this.date = 0;
        this.update_id = 0;
    }

    public Message(Persona from, Chat chat, int message_id, String text, int date, int update_id) {
        this.from = from;
        this.chat = chat;
        this.message_id = message_id;
        this.text = text;
        this.date = date;
        this.update_id = update_id;
    }

}
