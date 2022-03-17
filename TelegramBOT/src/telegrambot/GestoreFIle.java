/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telegrambot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samum
 */
public class GestoreFIle {

    public GestoreFIle() {

    }

    public void appendLocations(String path, List<Utenti> users) throws FileNotFoundException, IOException {
        System.out.println("APPENDS");
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        for (int i = 0; i < users.size(); i++) {
            str += users.get(i).toCSV() + "\n";
        }
        if (str.equals("")) {

        } else {
            bw.append(str);
            bw.close();

        }
    }

    public void appendLocation(String path, Utenti user) throws FileNotFoundException, IOException {
        System.out.println("APPEND");
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        str += user.toCSV() + "\n";
        if (str.equals("")) {

        } else {
            bw.append(str);
            bw.close();
        }
    }

    public void saveLocations(String path, List<Utenti> users) throws FileNotFoundException, IOException {
        System.out.println("WRITES");
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        for (int i = 0; i < users.size(); i++) {
            str += users.get(i).toCSV() + "\n";
        }
        if (str.equals("")) {

        } else {
            bw.write(str);
            bw.close();

        }
    }

    public void saveLocation(String path, Utenti user) throws FileNotFoundException, IOException {
        System.out.println("WRITE");
        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "";
        str += user.toCSV() + "\n";
        if (str.equals("")) {

        } else {
            bw.write(str);
            bw.close();
        }
    }

    public List<Utenti> loadLocations(String path) throws FileNotFoundException, IOException {
        List<Utenti> users = new ArrayList<Utenti>();
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        for (String line = ""; (line = br.readLine()) != null;) {
            Utenti u = Utenti.fromCSV(line);
            users.add(u);
        }
        br.close();
        return users;
    }

}
