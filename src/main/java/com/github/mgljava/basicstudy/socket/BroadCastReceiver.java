package com.github.mgljava.basicstudy.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadCastReceiver {

  public static void main(String[] args) {
    try {
      DatagramSocket datagramSocket = new DatagramSocket(8888);
      byte[] buf = new byte[5];
      DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
      datagramSocket.receive(datagramPacket);
      System.out.println(new String(buf));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
