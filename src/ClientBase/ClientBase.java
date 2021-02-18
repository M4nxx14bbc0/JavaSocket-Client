/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientBase;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parrarodriguez.manue
 */
public class ClientBase {
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args){
        System.out.println("Apertura connessione");
        try {
            while (true) {
                Socket server = new Socket("127.0.0.1", 5500);
                InputStream dalServer = server.getInputStream();
                BufferedReader lettore = new BufferedReader(new InputStreamReader(dalServer));

                String risposta = lettore.readLine();

                System.out.println("Risposta del server : "+risposta);
                lettore.close();
                server.close();

                System.out.println("Chiusura connessione !");
                Thread.sleep(5000);
            }
        } catch (InterruptedException interrupt) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, interrupt);
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}