package com.company.utilites;

import java.util.ArrayList;
import java.util.HashSet;

public class ElectoralVotingBallot {
    final private ArrayList<String> names = new ArrayList<>();
    final private ArrayList<Integer> count = new ArrayList<>();
    final private HashSet<Integer> countHashSet = new HashSet<>(count);

    private String selectedCandidate;
    private boolean isDone = false;
    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getCount() {
        return count;
    }
    public HashSet<Integer> getCountHashSet() { return countHashSet; }
    public String getSelectedCandidate() {
        return selectedCandidate;
    }
    public void setSelectedCandidate(String selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }
    public boolean isDone() {
        return isDone;
    }
    public void setDone(boolean done) {
        isDone = done;
    }
}
