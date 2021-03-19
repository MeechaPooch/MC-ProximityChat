package com.mooo.pooch.proximitychatstandaside;

import java.net.Socket;

public class ChatClient {




    public class ServerChatConnection {
        Thread recieveThread;
        Thread sendThread;
        Socket socket;

        public ServerChatConnection(Socket socket) {
            this.socket = socket;

        }
    }
}
