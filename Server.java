package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket server;
        Socket socket;
        Scanner sc;
        PrintWriter out;
        try {
            server = new ServerSocket(8080);
            System.out.println("Сервер включен ");
            socket = server.accept();
            sc = new Scanner(socket.getInputStream());
            System.out.println("Пользователь подключился ");
            out = new PrintWriter(socket.getOutputStream());
            new Thread(() -> {
                while(true){
                    System.out.println("Введите сообщение:");
                    String str = sc.nextLine();
                    System.out.println("Сервер: " + str);
                    out.println("Сервер: " + str);
                    if(str.equals("/end")){
                        try {
                            out.println("Сервер отключился");
                            server.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
