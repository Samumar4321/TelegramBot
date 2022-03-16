/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegrambot;

/**
 *
 * @author samum
 */
public class Utenti {

    String nomeCitta;
    int id_chat;
    double lat;
    double lon;

    public Utenti() {
    }

    public Utenti(String nomeCitta, int id_chat, double lat, double lon) {
        this.nomeCitta = nomeCitta;
        this.id_chat = id_chat;
        this.lat = lat;
        this.lon = lon;
    }

    public String toCSV() {
        String temp = id_chat + ";" + nomeCitta + ";" + lat + ";" + lon + ";";
        return temp;
    }

    public static Utenti fromCSV(String csv) {
        String[] vett = csv.split(";");
        Utenti u = new Utenti();
        u.id_chat = Integer.parseInt(vett[0]);
        u.nomeCitta = vett[1];
        u.lat = Double.parseDouble(vett[2]);
        u.lat = Double.parseDouble(vett[3]);
        return u;
    }
}
