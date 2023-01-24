import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args){

        try (ServerSocket serverSocket = new ServerSocket(8091); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Write your name");

            final String name = in.readLine();
            System.out.println(name);

            out.println(String.format("Hi, your port is %d, Are you child? (yes/no)", clientSocket.getPort()));

            final String answer = in.readLine();
            System.out.println(answer);
            if(answer.equals("yes")){
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
