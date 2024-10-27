
import java.rmi.*;

public interface Callback extends Remote {
    void onCallback(String message) throws RemoteException;
}
