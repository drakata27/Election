package com.company.utilites;

import java.util.ArrayList;
import java.util.HashSet;

//Public class that encapsulates the fields and methods used in the Main class
public class ElectoralVotingBallot {
    //The fields are declared as private and can be accessed only within the class they are in. This provides encapsulation.
    //The array lists and hash set are declared as final and this means that they are constant and cannot be reassigned to other variables
    final private ArrayList<String> names = new ArrayList<>();//Array list used for storing the names of the candidates
    final private ArrayList<Integer> count = new ArrayList<>();//Array list used for storing the vote count

    //Hash set that copies the content from the count list used for checking for duplicate values in case there are more than one winner
    final private HashSet<Integer> countHashSet = new HashSet<>(count);

    private String selectedCandidate; //String variable that stores the user's chosen candidate

    //boolean variable that is used for ending a loop in Main class that checks if the count list contains the selected candidate already.
    private boolean isDone = false;

    //Getter (accessor) and setter(mutator) methods used to access the private fields from other classes,
    // as long as there is an instance of the ElectoralVotingBallot class.
    public ArrayList<String> getNames() { //Getter that returns the names array list
        return names;
    }

    public ArrayList<Integer> getCount() { //Getter that returns the count array list
        return count;
    }
    public HashSet<Integer> getCountHashSet() { //Getter that returns the countHashSet
        return countHashSet;
    }
    public String getSelectedCandidate() { //Getter method that returns the selectedCandidate
        return selectedCandidate;
    }
    public void setSelectedCandidate(String selectedCandidate) { //Setter method that does not return anything but updates the value of selectedCandidate variable
        this.selectedCandidate = selectedCandidate;
    }
    public boolean isDone() { //Getter method that returns the isDone boolean variable
        return isDone;
    }
    public void setDone(boolean done) {//Setter method that updates the value of the isDone variable.
        isDone = done;
    }
}
