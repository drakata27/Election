import com.company.utilites.ElectoralVotingBallot;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElectoralVotingBallot ballot = new ElectoralVotingBallot(); //Creating instance of the ElectoralVotingBallot class
        Scanner scanner = new Scanner(System.in); //Creating instance of the Scanner class that accepts user input

        //For loop that prints the symbol "#" on the same line as long as int variable i is less than 41
        //First it creates integer variable called "i", then there is the condition for the loop that needs to be true so the loop can execute,
        //and finally there is the statement that executes after each iteration of the loop.
        for (int i = 0; i < 41; i++) {
            System.out.print("#");
        }

        //Print methods that briefly explain how to use the program
        System.out.println("\n# Enter the votes, one vote per line!   #");
        System.out.println("# End with either -1, or an empty line! #");

        //For loop that prints the symbol "#" on the same line as long as int variable i is less than 41
        for (int i = 0; i < 41; i++) {
            System.out.print("#");
        }

        //Do-while loop that will iterate the statements below as long as the condition in the while block is true.
        do {
            System.out.println("\nEnter a candidate: ");

            //Instance of the ElectoralVotingBallot class that calls a setter method.
            // This setter method accepts a String value as a parameter,
            // in this case it accepts user input from the scanner instance as a String.
            ballot.setSelectedCandidate(scanner.nextLine());

            //If statement that executes certain blocks of code depending on teh condition.
            //In this case, the condition is if the list that stores candidate names already contains that candidate,
            // It will increase their vote count by one
            if (ballot.getNames().contains(ballot.getSelectedCandidate())) {
                ballot.getCount().set(ballot.getNames().indexOf(ballot.getSelectedCandidate()),//Finds the index of the selected candidate
                        ballot.getCount().get(ballot.getNames().indexOf(ballot.getSelectedCandidate())) + 1); //Increases the count of votes by one

               //Else if statement that will execute if the condition above is not met.
                //In this case if the user does not type "-1" and they do not provide empty line,
                // what they type will be stored in the names list and 1 will be stored in the count list, in sense that a new candidate is added
            } else if (!ballot.getSelectedCandidate().equals("-1") && !ballot.getSelectedCandidate().isEmpty()){
                ballot.getNames().add(ballot.getSelectedCandidate()); //Instance of the ElectoralVotingBallot that calls a getter method to add the candidate name in the names list
                ballot.getCount().add(1); //Instance of the ElectoralVotingBallot that calls a getter method to add 1 to the count list

            //Else statement that runs if none of the above conditions is true
            } else {
                ballot.setDone(true); //Instance of the ElectoralVotingBallot that sets the boolean value of the variable isDone to true, so the loop ends
            }

        } while (!ballot.isDone()); //While block that contains the condition that will end the loop. When that condition becomes false, the loop ends.

        //If statement with nested if statements inside
        //This if statements checks if there are duplicates in the count list by copying its content to a hash set, since hash set does not allow duplicates.
        //This is done in order to check if there are candidates with the same number of votes that won the election
        if (ballot.getCountHashSet().size() < ballot.getCount().size()) {

            //Collection class that uses static method (static methods do not require instances) that shuffles the names list via its getter method,
            //in order to find a winner randomly in case there are candidates with the same number of votes that won the election.
            Collections.shuffle(ballot.getNames());

            //If statement that will be executed if names list is not empty or cont list is not empty
            if (!ballot.getNames().isEmpty() || !ballot.getCount().isEmpty()) {

                //For loop that prints the candidates and their number of received votes
                //The loop iterates as long as "i" is less than the names list's size
                for (int i = 0; i < ballot.getNames().size(); i++) {
                    System.out.print(ballot.getNames().get(i) + " received " + ballot.getCount().get(i));

                    //Ternary condition that checks if the count at index of the value of "i" is equal to one. If it is true
                    //it will print " vote", if it is false it will print " votes". This condition works like if statement, but it is less code
                    System.out.println(ballot.getCount().get(i) == 1 ? " vote" : " votes");

                }

                System.out.println("\nIn case there are two or more candidates that have the highest number of votes, the winner will be chosen randomly");

                System.out.print("The winner is " + ballot.getNames().get(ballot.getCount().indexOf(Collections.max(ballot.getCount()))) +
                        " with " + Collections.max(ballot.getCount()));
                //Ternary condition that checks if the maximum value of the count list is greater than 1.
                System.out.println(Collections.max(ballot.getCount()) > 1 ? " votes" : " vote");

            //Else statement that executes if the conditions above are not met. That means the user did not vote.
            } else {
                System.out.println("You did not vote.");
            }
        //Else statement that executes if there are no duplicates in the count list.
        } else {
            //If statement that is true if the names list is not empty and the count list is not empty
            if (!ballot.getNames().isEmpty() || !ballot.getCount().isEmpty()) {
                //For loop iterating over the names list
                for (int i = 0; i < ballot.getNames().size(); i++) {
                    System.out.println(ballot.getNames().get(i) + " received " + ballot.getCount().get(i));
                    //Ternary condition that prints " vote" if the condition is true and " votes" if it is false
                    System.out.println(ballot.getCount().get(i) == 1 ? " vote" : " votes");
                }
                System.out.print("The winner is " + ballot.getNames().get(ballot.getCount().indexOf(Collections.max(ballot.getCount()))) +
                            " with " + Collections.max(ballot.getCount()));
                //Ternary condition to reduce code
                System.out.println(Collections.max(ballot.getCount()) > 1 ? " votes" : " vote");
            //Else statement that executes if the user does not vote
            } else {
                System.out.println("You did not vote.");
            }
        }

        scanner.close(); //Method that closes the scanner object in order to avoid memory leak
    }
}