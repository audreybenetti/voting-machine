import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry record = LocateRegistry.getRegistry();
            Validation stub = (Validation) record.lookup("voting-machine");

            Scanner input = new Scanner(System.in);

            System.out.println("Digite o número do seu candidato: ");
            int vote = input.nextInt();
            stub.receiveVote("name", vote);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}