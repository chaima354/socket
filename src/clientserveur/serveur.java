/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserveur;

/**
 *
 * @author omen
 */
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class serveur {

    static final int port = 8000;

    public static void main(String[] args) throws Exception {

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");


        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        int nb = inServer.read();
        for (int i=1; i<=nb;i++) {
           int div=0; 
           int j=0 ;
           while ((j<=i) && (i % j!=0) )
           { j++;
               if (i % j==0)
               {
                   div++;
               }
            }
           if (div==0)
           {System.out.println(i);}
        }
        

      
        inServer.close();
        outServer.close();

        socClient.close();
    }
}
