import java.rmi.RemoteException;
import java.util.Scanner;

public class Urna implements Validation{

    private final CandidateRepository repository;
    Scanner input = new Scanner(System.in);

    public Urna(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean receiveVote(String name, int number) throws RemoteException {
        if(repository.candidateExists(number)){
            var candidate = repository.getCandidate(number);
            candidate.setVotesReceived(candidate.getVotesReceived() + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void countVote(int number, int option) throws RemoteException {

    }
}
