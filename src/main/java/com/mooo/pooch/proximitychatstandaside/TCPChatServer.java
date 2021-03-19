package com.mooo.pooch.proximitychatstandaside;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;

public class TCPChatServer {

    public LinkedList<ConnectedClient> connections = new LinkedList();
    ServerSocket serverSocket;

    public static void main(String... args) {
        new TCPChatServer().startServer();
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(Consts.SERVER_VOIP_PORT);
        } catch (IOException e) {
            System.out.println("Error starting voice server on port " + Consts.SERVER_VOIP_PORT);
            return;
        }
        try {
            String myaddr = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Server started at address [ " + myaddr + ":" + Consts.SERVER_VOIP_PORT + " ]");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                Socket newSocket = serverSocket.accept();
                connections.add(new ConnectedClient(newSocket));
            } catch (IOException e) {
                System.out.println("IO EXCEPTION OCCURED WHEN LISTENING FOR CHAT CLIENTS!");
                e.printStackTrace();
            }
        }
    }

    public class ConnectedClient {
        Thread thread;
        Socket socket;

//        DatagramSocket socket;

        public ConnectedClient(Socket socket) {
            System.out.println("New connection from " + socket.getRemoteSocketAddress().toString());
            this.socket = socket;
//            thread =


        }


    }

}
