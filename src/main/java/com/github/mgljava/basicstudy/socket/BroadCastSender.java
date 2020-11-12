package com.github.mgljava.basicstudy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class BroadCastSender {

  public static void main(String[] args) {
    try {
      InetAddress inetAddress = InetAddress.getByName("localhost");
      DatagramSocket ds = new DatagramSocket();
      String str = "hello";
      DatagramPacket dp = new DatagramPacket(str.getBytes(), 5, inetAddress, 8888);
      ds.send(dp);
      ds.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
