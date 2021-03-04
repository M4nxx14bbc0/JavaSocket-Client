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
            BufferedReader lettore = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter scrittore = new PrintWriter(server.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            int input = 0; 
            System.out.print("Testo : ");
            input = sc.nextInt();
            scrittore.write(input);
            scrittore.flush();
            
            System.out.println("Risultato : "+lettore.readLine());
            lettore.close();
            server.close();

            System.out.println("Chiusura connessione !");
            Thread.sleep(5000);
        } catch (InterruptedException interrupt) {
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}