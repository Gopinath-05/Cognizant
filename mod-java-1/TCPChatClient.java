import java.net.*;
import java.io.*;

public class TCPChatClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = stdin.readLine()) != null) {
            out.println(line);
            System.out.println("Server: " + in.readLine());
        }
        s.close();
    }
}
