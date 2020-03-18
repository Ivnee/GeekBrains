package Data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client(){
        try {
            Socket socket = new Socket("localhost",8181);
            System.out.println("Вы подключились к серверу :");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner sc = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                    try {
                        while (true){
                        String text = sc.nextLine();
                        String msg = in.readUTF();
                        out.writeUTF("Пользователь: "+ text);
                        out.writeUTF("Сервер: " + msg);
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
