import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validation extends Remote{
    boolean receiveVote(String name, int number) throws RemoteException;
    void countVote(int number, int option) throws RemoteException;
}
