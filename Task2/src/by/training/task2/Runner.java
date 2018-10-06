package by.training.task2;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Runner {
	public static final int PORT = 2080;
	static List<ServerThread> threads;
	
	public static void main(String[] args) {
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(PORT);
			threads = new ArrayList<>();
			System.out.println("Socket create successful!");
			addServerThread(socket);
		}catch (IOException e) {
			System.err.println("Can't create socket ");
		}
	}
	public static void addServerThread(ServerSocket s){
		threads.add(new ServerThread(s));
		threads.get(threads.size()-1).start();
	}

}