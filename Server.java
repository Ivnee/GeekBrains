package Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8181);
            System.out.println("Сервер включился");
            Socket socket = server.accept();
            System.out.println("Пользователь подключился");
            Scanner sc = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            new Thread(()-> {
                    try {
                        while(true){
                        String text = sc.nextLine();
                        String msg = in.readUTF();
                        out.writeUTF("Пользователь: "+ msg);
                        out.writeUTF("Сервер: " + text);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }).start();
            } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
