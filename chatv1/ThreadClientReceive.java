package com.example.chatv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClientReceive extends Thread {
    Socket clientSocket;
    BufferedReader in;
    PrintWriter out;
    Scanner sc = new Scanner(System.in);//pour lire à partir du clavier
    String msg;

    public ThreadClientReceive(Socket so) throws IOException {
        clientSocket = so;
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            msg = in.readLine();
            while (msg != null) {
                System.out.println("Server : " + msg);
                msg = in.readLine();
            }
            System.out.println("Server logout");
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}