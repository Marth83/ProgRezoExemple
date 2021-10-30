package com.example.chatv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class progClient {

    public static void main(String[] args) {

        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc = new Scanner(System.in);//pour lire à partir du clavier

        try {
            clientSocket = new Socket("localhost",5000);
            //flux pour envoyer
            out = new PrintWriter(clientSocket.getOutputStream());
            //flux pour recevoir
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ThreadClientSend clientSend = new ThreadClientSend(clientSocket);
            clientSend.start();
            ThreadClientReceive clientReceive =  new ThreadClientReceive(clientSocket);
            clientReceive.start();
            System.out.println("Bonjour! Veuillez rentrer votre nom : ");
            out.println(in.readLine());
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}