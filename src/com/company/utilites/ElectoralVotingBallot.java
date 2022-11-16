package com.company.utilites;

import java.util.ArrayList;
public class ElectoralVotingBallot {
    final private ArrayList<String> names = new ArrayList<>();
    final private ArrayList<Integer> count = new ArrayList<>();
    private String selectedCandidate;
    private boolean isDone = false;

    public ArrayList<String> getNames() {
        return names;
    }
    public ArrayList<Integer> getCount() {
        return count;
    }
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
