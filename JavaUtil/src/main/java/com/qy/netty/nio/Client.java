package com.qy.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 8080));
        //SocketAddress address = sc.getLocalAddress();
        System.out.println("waiting...");
        System.in.read();
        //sc.close();
    }
}