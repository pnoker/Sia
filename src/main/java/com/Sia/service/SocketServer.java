package com.Sia.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年12月22日
 * @description
 */

public class SocketServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServerSocket serverSocket;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			serverSocket = new ServerSocket(9999);
			Socket socket = null;
			System.out.println("***Socket Server 服务准备启动，启动端口为：9999，等待客户端的连接***");
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				InetAddress address = socket.getInetAddress();
				System.out.println("当前客户端的IP：" + address.getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
