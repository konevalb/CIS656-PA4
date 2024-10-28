
import java.rmi.*;

public interface Method extends Remote {
    void registerCallback(Callback callback, String input) throws RemoteException;
    String action(String input) throws RemoteException;
}
