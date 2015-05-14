package com.cs.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.cs.util.PropertiesUtil;

public class ExecueSocketServer {
	private static final Executor socketExec = Executors.newFixedThreadPool(1);

	/*
	 * private static final Executor writetExec=Executors.newFixedThreadPool(1);
	 * 
	 * private static final Executor readtExec=Executors.newFixedThreadPool(1);
	 */

	public static void readHeartBeat(Socket conn) {
		BufferedReader rdr = null;
		try {
			rdr = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String heartBeat = rdr.readLine();
			while (true) {
				System.out.println("recive data "+heartBeat);
				if (heartBeat.startsWith("START")) {
					System.out.println("string begin Start");
					heartBeat = rdr.readLine();
					if (heartBeat.startsWith("HEARTBEATEND")) {
						System.out.println("recived heartbeat.....");
					}
				}
				heartBeat = rdr.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rdr != null) {
					rdr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void handleRequest(Socket conn) {
		readHeartBeat(conn);
	}

	public static void main(String args[]) {
		ServerSocket server = null;
		try {
			String port = PropertiesUtil.getInstance().getAttribute(
					"socketPort");
			server = new ServerSocket(Integer.parseInt(port));
			while (true) {
				final Socket connect = server.accept();
				Runnable task = new Runnable() {
					public void run() {
						handleRequest(connect);
					}
				};
				socketExec.execute(task);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != server) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
