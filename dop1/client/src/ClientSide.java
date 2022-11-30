import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSide {

    private final Socket client;
    private final ObjectOutputStream out;

    private Dog1 dog;

    ClientSide(Socket client) throws IOException {                  //Adjustment 1.
        this.client = client;
        out = new ObjectOutputStream(client.getOutputStream());
    }
    //mockito capture (argumentCapture)

    public Dog1 getDog() {
        return dog;
    }

    public void run(Dog1 dog) throws IOException {                   //Adjustment 2.
        try {
            this.dog = dog;
            out.writeObject(dog);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null)
                out.close();
            if(client != null)
                client.close();
        }
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public static void main(String[] args) throws IOException {
        ClientSide clientSide = new ClientSide(new Socket(InetAddress.getLocalHost(), 8188));
        clientSide.run(new Dog1("Tom", "Black",10));

    }
}