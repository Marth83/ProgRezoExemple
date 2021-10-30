package com.example.chatv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClientSend extends Thread {
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;
    Scanner sc = new Scanner(System.in);//pour lire à partir du clavier
    String msg;

    public ThreadClientSend(Socket so) throws IOException {
        clientSocket = so;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            msg = sc.nextLine();
            out.println(msg);
            out.flush();
        }
    }
}