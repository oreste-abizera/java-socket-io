import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ServerDemo
 */
public class ServerDemo {

    public static void main(String[] args) {
        Integer port = 5050;
        try {         
        ServerSocket Server = new ServerSocket(port);
        System.out.println("server listening on port " + port + "....");
        Socket mySocket = Server.accept();

        DataInputStream input = new DataInputStream(mySocket.getInputStream());

        DataOutputStream output = new DataOutputStream(mySocket.getOutputStream());

        String request="";
        String response = "";
        
        Scanner reader = new Scanner(System.in);

        while (!request.equals("Exit")) {
            request = input.readUTF();
            System.out.println("Request received: "+ request);

            response = reader.nextLine();
            output.writeUTF(response);
            output.flush();
        }

        if(request.equals("Exit")){
        System.out.println("User Disconnecting.....");
        }

        // reader.close();
        input.close();
        mySocket.close();
        // Server.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}