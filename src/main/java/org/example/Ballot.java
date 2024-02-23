package org.example;

import java.util.Arrays;
import java.util.List;

public class Ballot {
    private final List<String> votes;

    public Ballot(String... votes) {
        this.votes = Arrays.asList(votes);
    }

    public List<String> getVotes() {
        return votes;
    }
}
