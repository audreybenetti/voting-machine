import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry record = LocateRegistry.getRegistry();
            VotingSystem stub = (VotingSystem) record.lookup("voting-machine");
            getVote(stub);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void getVote(VotingSystem stub) {
        Scanner input = new Scanner(System.in);
        while (true){
        System.out.println("Digite o número do seu candidato: ");
        int vote = input.nextInt();
        try {
            stub.receiveVote(vote);
            System.out.println("Voto computado!");
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
      }
    }
}