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
import java.net.Socket;
import java.util.Scanner;
public class client {

    static final int port = 8000;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("connection request");
        Socket socket = new Socket("localhost", port);
        System.out.println("Connection established");
        BufferedReader inClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outClient = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        int nb = scan.nextInt();
        outClient.println(nb); 
        
        inClient.close();
        outClient.close();

        socket.close();
        scan.close();
    }
}

