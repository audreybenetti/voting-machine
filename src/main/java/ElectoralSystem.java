import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectoralSystem extends Remote{
    void receiveVote(int vote) throws Exception;
    void countVote() throws RemoteException;
}
