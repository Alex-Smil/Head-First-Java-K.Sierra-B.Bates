import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Саша on 21.06.2017.
 */
public class DailyAdviceServer {

    String[] adviceList = {"Ешьте меньшими порциями", "Купите облегчающие джинсы. Нет, они не делают Вас полнее",
    "Два слова : не годится"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket soc = serverSocket.accept();

                PrintWriter writer = new PrintWriter(soc.getOutputStream());
                String advice = getADvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getADvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
