import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    Socket client;
    ObjectInputStream in;
    Dog1 dog;

    Server() throws IOException {
        dog = new Dog1();

        server = new ServerSocket(8188);
        client = server.accept();

        in = new ObjectInputStream(client.getInputStream());
    }

    public Dog1 getDog() {
        return dog;
    }

    public void run() throws IOException {
        try {
            dog = (Dog1) in.readObject();
            System.out.println(dog.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (client != null)
                client.close();
            if (server != null)
                server.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }
}