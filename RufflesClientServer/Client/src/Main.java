import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String host = "netology.homework";
        int port = 8089;
        String resp = null;


        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

            //
            resp = in.readLine();
            System.out.print("Server: " + resp);
            //
            String answer = scan.nextLine();
            out.println(answer);
            //
            resp = in.readLine();
            System.out.print("Server: " + resp); // Хорошо. Чем могу помочь?
            //
            answer = "Могу я задать тебе вопрос?";
            out.println(answer);
            System.out.println("\nClient: " + answer);
            Thread.sleep(1000);
            resp = in.readLine(); // Конечно!
            System.out.println("Server: " + resp);
            //
            answer = "Как можно перенаправлять запросы с netology.homework на localhost?";
            out.println(answer);
            System.out.println("Client: " + answer);
            resp = in.readLine(); // Надо отредактировать файл hosts. Только не вручную
            System.out.println("Server: " + resp);
            //
            answer = "А как?";
            out.println(answer);
            System.out.println("Client: " + answer);
            resp = in.readLine(); //Установи служебную утилиту MS PowerToys. В ней есть редактор для файла hosts.
            System.out.println("Server: " + resp);
            //
            resp = in.readLine(); // Я помог?
            System.out.println("Server: " + resp);
            answer = "Да. Спасибо!";
            out.println(answer);
            System.out.println("Client: " + answer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}