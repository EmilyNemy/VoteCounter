import org.example.Ballot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BallotTest {
    @Test
    public void testGetCandidateList(){
        Ballot ballot = new Ballot("Person1", "Person2", "Person3");
        Assertions.assertEquals(Arrays.asList("Person1", "Person2", "Person3"), ballot.getVotes());
    }
}
