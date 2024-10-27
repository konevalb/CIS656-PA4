
import java.rmi.*;
import java.io.Serializable;
import java.util.Scanner;

public class MyClient implements Callback, Serializable {
    public static void main(String[] args) {
        try {
            Method stub = (Method) Naming.lookup("rmi://localhost:5000/lab6");
            stub.registerCallback(new MyClient());

            Scanner scanner = new Scanner(System.in);
            String input;

            while (true) {
                System.out.print("Enter a string (empty to quit): ");
                input = scanner.nextLine();

                if (input.isEmpty()) break;

                String response = input.equalsIgnoreCase("time") ?
                                  stub.getTime() : stub.capitalize(input);

                System.out.println("Using RMI: " + response);
            }

            System.out.println("Client exiting...");
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void onCallback(String message) throws RemoteException {
        System.out.println("Using Callback: " + message);
    }
}
