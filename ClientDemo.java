import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) {
        Integer port = 5050;

        try {
            Socket clientSocket = new Socket("localhost",port);

        DataInputStream input = new DataInputStream(clientSocket.getInputStream());

        DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());


        String request="";
        String response = "";
        
        Scanner reader = new Scanner(System.in);

        while(!request.equals("Exit")){
            request = reader.nextLine();
            output.writeUTF(request);
            output.flush();

            response = input.readUTF();
            System.out.println("Response is: " + response);
        }

        input.close();


        } catch (Exception e) {
            //TODO: handle exception
        }
}
}
