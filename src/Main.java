import com.company.utilites.ElectoralVotingBallot;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElectoralVotingBallot ballot = new ElectoralVotingBallot();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 41; i++) {
            System.out.print("#");
        }

        System.out.println("\n# Enter the votes, one vote per line!   #");
        System.out.println("# End with either -1, or an empty line! #");

        for (int i = 0; i < 41; i++) {
            System.out.print("#");
        }

        do {
            System.out.println("\nEnter a candidate: ");
            ballot.setSelectedCandidate(scanner.nextLine());

             if (ballot.getNames().contains(ballot.getSelectedCandidate())) {
                ballot.getCount().set(ballot.getNames().indexOf(ballot.getSelectedCandidate()),
                        ballot.getCount().get(ballot.getNames().indexOf(ballot.getSelectedCandidate())) + 1);

            } else if (!ballot.getSelectedCandidate().equals("-1") && !ballot.getSelectedCandidate().isEmpty()){
                ballot.getNames().add(ballot.getSelectedCandidate());
                ballot.getCount().add(1);

            } else {
                ballot.setDone(true);
            }

        } while (!ballot.isDone());

        if (!ballot.getNames().isEmpty() || !ballot.getCount().isEmpty()) {
            for (int i = 0; i < ballot.getNames().size(); i++) {
                if (ballot.getCount().get(i) == 1) {
                    System.out.println(ballot.getNames().get(i) + " received " + ballot.getCount().get(i) + " vote");
                } else {
                    System.out.println(ballot.getNames().get(i) + " received " + ballot.getCount().get(i) + " votes");
                }
            }
            if (Collections.max(ballot.getCount()) > 1) {
                System.out.println("The winner is " + ballot.getNames().get(ballot.getCount().indexOf(Collections.max(ballot.getCount()))) +
                        " with " + Collections.max(ballot.getCount()) + " votes");
            } else {
                System.out.println("The winner is " + ballot.getNames().get(ballot.getCount().indexOf(Collections.max(ballot.getCount()))) +
                        " with " + Collections.max(ballot.getCount()) + " vote");
            }
        } else {
            System.out.println("You did not vote.");
        }

        scanner.close();
    }
}