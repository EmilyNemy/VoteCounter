import org.example.Candidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CandidateTest {
    @Test
    public void testGetCandidate(){
        Candidate candidate = new Candidate("Candidate1");
        Assertions.assertEquals("Candidate1", candidate.getName());
    }

    @Test
    public void testAddPoints(){
        Candidate candidate = new Candidate("Candidate1");
        candidate.add(3);
        Assertions.assertEquals(3, candidate.getPoints());
    }

    @Test
    public void testEqualsMethod(){
        Candidate candidate0 = new Candidate("Candidate0");
        Candidate candidate1 = new Candidate("Candidate0");
        Assertions.assertEquals(candidate1, candidate0);
    }
}
