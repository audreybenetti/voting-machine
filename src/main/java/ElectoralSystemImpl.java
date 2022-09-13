import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElectoralSystemImpl implements ElectoralSystem {

    private final CandidateRepository repository;

    public ElectoralSystemImpl() {
        repository = new CandidateRepository();
    }

    @Override
    public synchronized void receiveVote(int vote) throws Exception {
        var candidate = repository.getCandidate(vote);
        candidate.setVotesReceived(candidate.getVotesReceived() + 1);
    }

    @Override
    public void countVote() throws RemoteException{
        System.out.printf("\n\n----------------- %s -----------------", getDate());
        repository.getCandidateList()
                .forEach(candidate ->
                        System.out.printf("\n%s com total de %d votos.",
                                candidate.getName(), candidate.getVotesReceived()));
    }

    public String getDate(){
        var now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
