package com.Sia.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.Sia.util.tools.MySql;

public class ServerThread extends Thread {
	Socket socket = null;
	MySql mySql = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
		this.mySql = new MySql();
	}

	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("接收消息：" + info);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				int nodeId = Integer.parseInt(info.toString().split(",")[0]);
				float value = Float.parseFloat(info.toString().split(",")[1]);
				long time = Long.parseLong(info.toString().split(",")[2]) * 1000;
				System.out.println("NodeID:" + nodeId + "\nValue:" + value + "\nTime:" + sdf.format(time));
				String sql = "update data_real set value = 'value' , at_time = 'sdf.format(time)'";
				mySql.executeUpdate(sql);
			}
			socket.shutdownInput();
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("连接成功！");
			pw.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
				if (mySql != null)
					mySql.free();
				System.out.println("本次连接关闭！");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}