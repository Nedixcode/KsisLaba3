package com.chat;

import com.chat.core.PeerNode;
import com.chat.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        String name = "User"; String ip = "127.0.0.1";
        int tcpPort = 9000; int udpPort = 8888;

        for (String arg : args) {
            if (arg.startsWith("--name=")) name = arg.substring(7);
            if (arg.startsWith("--ip=")) ip = arg.substring(5);
            if (arg.startsWith("--tcp-port=")) tcpPort = Integer.parseInt(arg.substring(11));
        }

        System.out.println("\nStarting peer:");
        System.out.println("Name: " + name);
        System.out.println("TCP port: " + tcpPort);
        System.out.println("UDP port: " + udpPort);

        PeerNode node = new PeerNode(name, ip, udpPort, tcpPort);
        ConsoleUI ui = new ConsoleUI(node);
        node.start();
        ui.start();
    }
}