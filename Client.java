package hw6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;
    Scanner sc;
    PrintWriter out;

    public Client() {
        try {
            socket = new Socket("localhost", 8080);
            System.out.println("Вы вошли на сервер: ");
            sc = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream());
            new Thread(() -> {
                while(true){
                    String str = sc.nextLine();
                    System.out.println("Клиент: " + str);
                    out.println("Клиент: " + str);
                    if(str.equals("/end")){
                        try {
                            out.println("Пользователь отключился");
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
