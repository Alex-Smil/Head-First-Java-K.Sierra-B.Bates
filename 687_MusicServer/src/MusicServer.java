import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Smile on 27.06.2017.
 */
public class MusicServer {
    ArrayList<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket clientSocket;

        public ClientHandler(Socket socket) {
            try {
                clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (Exception ex) {ex.printStackTrace();}
        }

        public void run() {
            Object o2 = null;
            Object o1 = null;
            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();

                    System.out.println("read two objects");
                    tellEveryone(o1, o2);
                }
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }// Закрываем inner class ClientHandler implements Runnable

    public void go() {
        clientOutputStreams = new ArrayList<>();
        try {
            ServerSocket serverSoc = new ServerSocket(4242);

            while (true) {
                Socket clientSocket = serverSoc.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();

                System.out.println("got a connection");
            }
        } catch (Exception e) {e.printStackTrace();}
    }// Close go()

    public void tellEveryone(Object one, Object two) {
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                ObjectOutputStream out =  (ObjectOutputStream) it.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception e) {e.printStackTrace();}
        }
    }// Close tellEveryone(Object one, Object two)

}
