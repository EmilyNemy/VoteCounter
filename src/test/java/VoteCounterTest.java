import org.example.Ballot;
import org.example.VoteCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class VoteCounterTest {
    @Test
    public void testVoteCounter() {
        VoteCounter voteCounter = new VoteCounter();
        Ballot ballot = new Ballot("Candidate0", "Candidate1", "Candidate2");

        List<String> candidates = voteCounter.getCandidates(Arrays.asList(ballot));
        List<String> expected = Arrays.asList("Candidate0", "Candidate1", "Candidate2");

        Assertions.assertEquals(expected, candidates);
    }

    @Test
    public void testSecondMethodThatWorks(){
        VoteCounter voteCounter = new VoteCounter();
        Ballot ballot = new Ballot("Candidate0", "Candidate1", "Candidate2");

        List<String> candidates = voteCounter.determineWinner(Arrays.asList(ballot));
        List<String> expected = Arrays.asList("Candidate0", "Candidate1", "Candidate2");

        Assertions.assertEquals(candidates, expected);
    }

    @Test
    public void testTieBreaking(){
        VoteCounter voteCounter = new VoteCounter();
        Ballot ballot = new Ballot("CandidateA", "CandidateB", "CandidateC");
        Ballot ballot2 = new Ballot("CandidateB", "CandidateA", "CandidateC");

        List<String> candidates = voteCounter.getCandidates(Arrays.asList(ballot, ballot2));
        List<String> expected = Arrays.asList("CandidateA", "CandidateB", "CandidateC");

        Assertions.assertEquals(expected, candidates);
    }

    @Test
    public void testTieBreakingSecond(){
        VoteCounter voteCounter = new VoteCounter();
        Ballot ballot = new Ballot("CandidateA", "CandidateB", "CandidateC");
        Ballot ballot2 = new Ballot("CandidateB", "CandidateA", "CandidateC");

        List<String> candidates = voteCounter.determineWinner(Arrays.asList(ballot, ballot2));
        List<String> expected = Arrays.asList("CandidateA", "CandidateB", "CandidateC");

        Assertions.assertEquals(expected, candidates);
    }
}


