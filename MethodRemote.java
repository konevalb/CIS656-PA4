
import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;


public class MethodRemote extends UnicastRemoteObject implements Method {

    public MethodRemote() throws RemoteException {
        super();
    }

    @Override
    public void registerCallback(Callback callback, String input) throws RemoteException {
        String response = action(input);
        callback.onCallback(response);
    }

    @Override
    public String action(String input) throws RemoteException {
        if ("time".equalsIgnoreCase(input)){
            return new Date().toString();
        } else {
            return input.toUpperCase();
        }
    }

}
