import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {

        out.println("Server started");
        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    out.println("Привет! Как к тебе обращаться? ");
                    String name = in.readLine();  // имя клиента
                    //
                    out.println(String.format("Хорошо, %s. Чем могу помочь?", name));
                    String resp = in.readLine(); // Могу я задать тебе вопрос?
                    out.println("Конечно!");
                    //
                    resp = in.readLine(); // Как можно перенаправлять запросы с netology.homework на localhost?
                    out.println("Надо отредактировать файл hosts. Только не в обычном редакторе");
                    //
                    resp = in.readLine(); // Как можно перенаправлять запросы с netology.homework на localhost?
                    out.println("Установи служебную утилиту MS PowerToys. В ней есть редактор для файла hosts.");
                    //
                    out.println("Я помог?");
                    resp = in.readLine(); // Да. Спасибо!
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}