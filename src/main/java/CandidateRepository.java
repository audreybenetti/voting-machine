import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public class CandidateRepository {

    private final List<Candidate> candidateList = new ArrayList<>();

    public void initialize() {
        Candidate c1 = new Candidate("Luiz Inácio da Silva", 13);
        Candidate c2 = new Candidate("Ciro Gomes", 12);
        Candidate c3 = new Candidate("Simone Tebet", 15);

        candidateList.add(c1);
        candidateList.add(c2);
        candidateList.add(c3);
    }

    public Candidate getCandidate(int number) throws RemoteException {
        return candidateList.stream().filter(candidate -> candidate.getNumber() == number).findFirst().orElseThrow();
    }

    public boolean candidateExists(int number) throws RemoteException {
        return candidateList.contains(getCandidate(number));
    }
}
