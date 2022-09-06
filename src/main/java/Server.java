import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server{

    public Server() {
    }

    public static void main(String[] args) {
        try {
            CandidateRepository repository = new CandidateRepository();
            Validation server = new Urna(repository);
            Validation skeleton = (Validation) UnicastRemoteObject.exportObject(server, 0);
            Registry record = LocateRegistry.getRegistry();
            record.rebind("voting-machine", skeleton);

            System.out.println("Servidor de votação [OK]");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
