import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server extends Thread implements Validation {

    private final CandidateRepository repository;

    public Server() {
        repository = new CandidateRepository();
    }

    public static void main(String[] args) {
        try {
            Validation server = new Server();
            Validation skeleton = (Validation) UnicastRemoteObject.exportObject(server, 0);
            Registry record = LocateRegistry.getRegistry();
            record.rebind("voting-machine", skeleton);

            System.out.println("Servidor de votação [OK]");

            Server thread = new Server();
            thread.start();
            skeleton.countVote();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void receiveVote(String name, int number) throws RemoteException {
        var candidate = repository.getCandidate(number);
        candidate.setVotesReceived(candidate.getVotesReceived() + 1);
    }

    @Override
    public void countVote() throws RemoteException, InterruptedException {
        do {
            sleep(5000);
            System.out.printf("\n\n------------------ %s ------------------", getDate());
            repository.getCandidateList()
                    .forEach(candidate ->
                            System.out.printf("\n%s com total de %d votos.",
                                    candidate.getName(), candidate.getVotesReceived()));
        } while (!isInterrupted());
    }

    public String getDate(){
        var now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
