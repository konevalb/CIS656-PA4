
import java.rmi.*;

public interface Method extends Remote {
    String getTime() throws RemoteException;
    String capitalize(String input) throws RemoteException;
    void registerCallback(Callback callback) throws RemoteException;
}
