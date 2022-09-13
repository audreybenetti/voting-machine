import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validation extends Remote{
    void receiveVote(String name, int number) throws RemoteException;
    void countVote() throws RemoteException, InterruptedException;
}
