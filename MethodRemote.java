
import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class MethodRemote extends UnicastRemoteObject implements Method {
    private Callback clientCallback;

    public MethodRemote() throws RemoteException {
        super();
    }

    @Override
    public String getTime() throws RemoteException {
        String result = new Date().toString();
        sendMessage(result);
        return result;
    }

    @Override
    public String capitalize(String input) throws RemoteException {
        String result = input.toUpperCase();
        sendMessage(result);
        return result;
    }

    @Override
    public void registerCallback(Callback callback) throws RemoteException {
        this.clientCallback = callback;
    }

    private void sendMessage(String message) throws RemoteException {
        if (clientCallback != null) {
            clientCallback.onCallback(message);
        }
    }
}
