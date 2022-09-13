import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VotingSystem extends Remote{
    void receiveVote(int vote) throws Exception;
    void countVote() throws RemoteException;
}
