package com.example.chatv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class progServeur {

    public static void main(String[] test) {

        final ServerSocket serveurSocket  ;
         Socket clientSocket ;
         BufferedReader in;
         PrintWriter out;
         Scanner sc=new Scanner(System.in);

        try {
            serveurSocket = new ServerSocket(5000);
            while(true) {
                clientSocket = serveurSocket.accept();
                System.out.println("New connection from " + clientSocket.getInetAddress().getHostAddress());
                out = new PrintWriter(clientSocket.getOutputStream());
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ThreadClientSend clientSend = new ThreadClientSend(clientSocket);
                clientSend.start();
                ThreadClientReceive clientReceive = new ThreadClientReceive(clientSocket);
                clientReceive.start();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}