package labs.six.instruments.variant1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Created by thecat on 16.05.15.
 */
public class WebListener {

    private final ServerAnswerer answerer;
    String host = "localhost";
    int port = 8080;
    private ServerSocket socket;

    public WebListener(ServerAnswerer answerer) {
        this.answerer = answerer;
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            socket = null;
            e.printStackTrace();
        }
    }

    public void startListen(){
        try {
            if(socket == null){
                System.out.println("Can't listen port: " + port);
            }
            System.out.println("I'm waiting ");

            Socket worker = socket.accept();

            System.out.println("Somebody connect to me ");
            BufferedReader in = new BufferedReader(new InputStreamReader(worker.getInputStream()));
            StringBuilder bld = new StringBuilder();
            String buffer;
            while((buffer = in.readLine()) != null && !buffer.isEmpty()){
                bld.append(buffer);
            }

            answerer.askMe(bld, worker.getOutputStream());
            System.out.println("I'm answered");
            in.close();
            startListen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
