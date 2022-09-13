import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Optional;

public interface Validation extends Remote{
    void receiveVote(int vote) throws Exception;
    void countVote() throws RemoteException;
}
