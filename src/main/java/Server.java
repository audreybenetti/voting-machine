import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Thread {

    public static void main(String[] args) {
        try {
            Validation server = new ValidationImpl();
            Validation skeleton = (Validation) UnicastRemoteObject.exportObject(server, 0);
            Registry record = LocateRegistry.getRegistry();
            record.rebind("voting-machine", skeleton);

            System.out.println("Servidor de votação [OK]");

            Server thread = new Server();
            thread.start();
            printsVotesPeriodically(skeleton, thread);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printsVotesPeriodically(Validation skeleton, Server thread)
            throws InterruptedException, RemoteException {
        do {
            sleep(5000);
            skeleton.countVote();
        } while (!thread.isInterrupted());
    }
}
