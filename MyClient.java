
import java.rmi.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            Method stub = (Method) Naming.lookup("rmi://localhost:1099/lab6");

            Scanner scanner = new Scanner(System.in);
            String input;

            while (true) {
                System.out.print("Enter a string (empty to quit): ");
                input = scanner.nextLine();

                if (input.isEmpty()) break;

                String response = stub.action(input);
                System.out.println("Using RMI: " + response);


                CallbackImplementation callback = new CallbackImplementation();
                stub.registerCallback(callback, input);

            }

            scanner.close();

            System.out.println("Client exiting...");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
