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
                ballot.getCount().set(ballot.getNames().indexOf(ballot.getSelectedCandidate()),//index of the selected candidate
                        ballot.getCount().get(ballot.getNames().indexOf(ballot.getSelectedCandidate())) + 1);

                System.out.println("getNames: " + ballot.getNames()); //remove
                System.out.println("getCount: " + ballot.getCount()); //remove
            } else if (!ballot.getSelectedCandidate().equals("-1") && !ballot.getSelectedCandidate().isEmpty()){
                ballot.getNames().add(ballot.getSelectedCandidate());
                ballot.getCount().add(1);

                System.out.println("getNames: " + ballot.getNames()); //remove
                System.out.println("getCount: " + ballot.getCount()); //remove
            } else {
                ballot.setDone(true);
            }

        } while (!ballot.isDone());


        if (ballot.getCountHashSet().size() < ballot.getCount().size()) {
            Collections.shuffle(ballot.getNames());

            if (!ballot.getNames().isEmpty() || !ballot.getCount().isEmpty()) {
                for (int i = 0; i < ballot.getNames().size(); i++) {
                    if (ballot.getCount().get(i) == 1) {
                        System.out.println(ballot.getNames().get(i) + " received " + ballot.getCount().get(i) + " vote");
                    } else {
                        System.out.println(ballot.getNames().get(i) + " received " + ballot.getCount().get(i) + " votes");
                    }
                }
                if (Collections.max(ballot.getCount()) > 1) {
                    System.out.println("\nIn case there are two or more candidates that have the highest number of votes, the winner will be chosen randomly");
                    System.out.println("The winner is " + ballot.getNames().get(ballot.getCount().indexOf(Collections.max(ballot.getCount()))) +
                            " with " + Collections.max(ballot.getCount()) + " votes");
                } else {
                    System.out.println("\nIn case there are two or more candidates that have the highest number of votes, the winner will be chosen randomly");
                    System.out.println("The winner is " + ballot.getNames().get(ballot.getCount().indexOf(Collections.max(ballot.getCount()))) +
                            " with " + Collections.max(ballot.getCount()) + " vote");
                }
            } else {
                System.out.println("You did not vote.");
            }

        } else {
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
        }
        System.out.println(ballot.getNames()); //Remove those
        System.out.println(ballot.getCount()); //Remove those

        scanner.close(); //Method that closes the scanner object in order to avoid memory leak
    }
}