/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientBase;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
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
            Socket server = new Socket("127.0.0.1", 5500);
            
            InputStream dalServer = server.getInputStream();
            OutputStream alServer = server.getOutputStream();
            
            BufferedReader lettore = new BufferedReader(new InputStreamReader(dalServer));
            BufferedWriter scrittore = new BufferedWriter(new OutputStreamWriter(alServer));
            Scanner sc = new Scanner(System.in);
            
            String input = ""; 
            
            while (!input.equalsIgnoreCase("exit")) {
                System.out.println("Testo : ");
                String risposta = sc.nextLine();

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