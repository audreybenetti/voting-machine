import java.io.Serializable;

public class Candidate implements Serializable {
    private final String name;
    private final int number;
    private int votesReceived;

    public Candidate(String name, int number) {
        this.name = name;
        this.number = number;
        this.votesReceived = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getVotesReceived() {
        return votesReceived;
    }

    public void setVotesReceived(int votesReceived) {
        this.votesReceived = votesReceived;
    }
}