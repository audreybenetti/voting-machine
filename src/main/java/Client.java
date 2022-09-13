import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry record = LocateRegistry.getRegistry();
            Validation stub = (Validation) record.lookup("voting-machine");
            getVote(stub);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void getVote(Validation stub) throws RemoteException {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número do seu candidato: ");
        int vote = input.nextInt();
        stub.receiveVote(vote);
    }
}