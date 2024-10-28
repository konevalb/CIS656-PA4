
import java.rmi.*;
import java.rmi.registry.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            MethodRemote stub = new MethodRemote();
            Naming.rebind("rmi://localhost:1099/lab6", stub);
            System.out.println("The Server is running!");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}
