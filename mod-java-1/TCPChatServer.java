import java.net.*;
import java.io.*;

public class TCPChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Client: " + line);
            out.println(stdin.readLine());
        }
        s.close(); ss.close();
    }
}
