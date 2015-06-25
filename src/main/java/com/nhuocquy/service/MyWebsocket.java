package com.nhuocquy.service;

import java.net.URI;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class MyWebsocket extends WebSocketClient {
	// s = "ws://192.168.117.191:8080/tuyensinhchat/chat?id=100";
	public MyWebsocket(String s) {
		super(URI.create(s));
		System.out.println("contructor: " + s);
		connect();
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		System.out.println("Open");
	}

	@Override
	public void onMessage(String s) {
		System.out.println(s);
	}

	@Override
	public void onError(Exception e) {
		System.out.println(e.getMessage());
	}

	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		System.out.println("Close");
	}

	public static void main(String[] args) {
		MyWebsocket s = new MyWebsocket("");
		System.out.println(s.isOpen());
		// s.connect();
		// try {
		// s.connectBlocking();
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		// while(true) {
		while (!s.isOpen())
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println(s.isOpen());
		// }
		// s.send("aaaaaaaaaaaa");
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
