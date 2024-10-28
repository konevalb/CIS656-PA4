import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImplementation extends UnicastRemoteObject implements Callback{
    
    public CallbackImplementation() throws RemoteException {
        super();
    }

    @Override
    public void onCallback(String message) throws RemoteException {
        System.out.println("Using Callback: " + message);
    }


}

