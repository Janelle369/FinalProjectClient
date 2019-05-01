import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Socket sock;
        BufferedReader from;
        PrintWriter to;
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter IP address: ");
        String ip = kbd.nextLine().trim();

        try {
            sock = new Socket(ip, 36911);
            System.out.println("Connected to " +
                    sock.getInetAddress());
            from = new BufferedReader(
                    new InputStreamReader(
                            sock.getInputStream()
                    )
            );
            to = new PrintWriter(sock.getOutputStream(),
                    true);
            while (true) {
             /*   System.out.println("Waiting ...");
                String response = from.readLine();
                System.out.println("them: " + response);
                if (response.equals("hihi")){
                    System.out.println("client notices server says hihi and client is going to do sth");
                }

                System.out.print("me: ");
                String s = kbd.nextLine();
                to.println(s);*/


                System.out.println("Press <Enter> to request a quote:");
                // client's response
                String s = kbd.nextLine();
                to.println(s);
                if (s.isEmpty()){
                    System.out.println("Requesting quote...");
                }

                // read num1 and num2 from media
                String num1 = from.readLine();
                String num2 = from.readLine();

                // print "Received factor xxxx, xxxxx"
                System.out.println("Finding factors of " + num1 +", " + num2);

                System.out.println("Found factors: ");

                String fac1 = kbd.nextLine();
                String fac2 = kbd.nextLine();

                to.println(fac1);
                to.println(fac2);

                String correct = from.readLine();
                System.out.println("Received" + correct);

                //received quote
                String quote  = from.readLine();
                System.out.println("Receive quote" + quote);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
