import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket sock;
        Socket client;
        BufferedReader from;
        PrintWriter to;

        Scanner kbd = new Scanner(System.in);


        // todo this is where big integer gets generated

        try {
            sock = new ServerSocket(36911);
            System.out.println("Waiting for connection ...");
            client = sock.accept();
            System.out.println("Connected to " +
                    client.getInetAddress());
            from = new BufferedReader(
                    new InputStreamReader(
                            client.getInputStream()
                    )
            );

            to = new PrintWriter(client.getOutputStream(),
                    true);

            while (true) {
                /*System.out.println("me: ");
                String s = kbd.nextLine();
                to.println(s);

                if (s.equals("hihi")){
                    System.out.println("server says hihi");
                }
                String response = from.readLine();   // from client
                System.out.println(response);

                System.out.println("My response: ");*/

                Random myRandom = new Random();
                // BigInteger(int numBits, Random rnd)
                BigInteger tmp1 = new BigInteger(20, myRandom);
                BigInteger prime1 = tmp1.nextProbablePrime();
                BigInteger tmp2 = new BigInteger(20, myRandom);
                BigInteger prime2 = tmp2.nextProbablePrime();
                BigInteger tmp3 = new BigInteger(10, myRandom);
                BigInteger prime3 = tmp3.nextProbablePrime();
                BigInteger tmp4 = new BigInteger(10, myRandom);
                BigInteger prime4 = tmp4.nextProbablePrime();

                BigInteger num1 = prime1.multiply(prime2);
                BigInteger num2 = prime3.multiply(prime4);


                String response = from.readLine();

                if (response.isEmpty()){
                    System.out.println("Received quote request from client!");
                    System.out.println("Sending " + num1 + ", " + num2 + " to Client.");

                    // pass num1 and num2 to the media
                    to.println(num1);
                    to.println(num2);


                    // find factors for num1 and num2
                    BigInteger fac1 = new BigInteger("100");
                    BigInteger fac2 = new BigInteger("200");

                    // pass fac1 and fac2 to media
                    to.println(fac1);
                    to.println(fac2);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
