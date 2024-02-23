package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class VoteCounter {

    public List<String> getCandidates(List<Ballot> ballots) {
        Map<String, Candidate> candidates = new HashMap<String, Candidate>();

        ballots.forEach(ballot -> {
            AtomicInteger counter = new AtomicInteger(3);
            ballot.getVotes().forEach(name -> {
                if(counter.get() > 0){
                    if(candidates.containsKey(name)){
                        Candidate candidate = candidates.get(name);
                        candidate.add(counter.getAndDecrement());
                    }
                    else{
                        Candidate candidate = new Candidate(name);
                        candidate.add(counter.getAndDecrement());
                        candidates.put(name, candidate);
                    }
                }
            });
        });
        return candidates.entrySet().stream()
                .sorted(
//                        (can1, can2) -> Integer.compare(can2.getValue().getPoints(), can1.getValue().getPoints())
                        (can1, can2) -> {
                    int pointsComparison = Integer.compare(can2.getValue().getPoints(), can1.getValue().getPoints());
                    return pointsComparison != 0 ? pointsComparison : can1.getKey().compareTo(can2.getKey());}
                ).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // TODO alternative
    public List<String> determineWinner(List<Ballot> ballots) {
        Map<String, Integer> candidatePoints = new HashMap<>();

        for (Ballot ballot : ballots) {
            List<String> votes = ballot.getVotes();
            for (int i = 0; i < Math.min(votes.size(), 3); i++) {
                String candidateName = votes.get(i);
                candidatePoints.put(candidateName, candidatePoints.getOrDefault(candidateName, 0) + 3 - i);
            }
        }

        List<Map.Entry<String, Integer>> sortedCandidates = new ArrayList<>(candidatePoints.entrySet());
        sortedCandidates.sort((c1, c2) -> c2.getValue().compareTo(c1.getValue()));

        sortedCandidates.sort((c1, c2) -> {
            int pointsComparison = c2.getValue().compareTo(c1.getValue());
            if (pointsComparison != 0) {
                return pointsComparison; // Sort by points descendingly
            } else {
                return c1.getKey().compareTo(c2.getKey()); // If points are equal, sort by candidate name
            }
        });

        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedCandidates) {
            winners.add(entry.getKey());
        }

        return winners;
    }

}
