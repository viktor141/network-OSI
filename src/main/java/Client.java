import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8091;

        try(Socket clientSocket = new Socket(host, port);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){

            System.out.println(in.readLine());

            out.println("Victor");
            System.out.println(in.readLine());

            out.println("no");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
