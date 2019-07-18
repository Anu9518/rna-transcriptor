import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @Before
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEmptyRnaSequence() {
        assertEquals("", rnaTranscription.transcribe(""));
    }


    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        assertEquals("G", rnaTranscription.transcribe("C"));
    }

    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        assertEquals("C", rnaTranscription.transcribe("G"));
    }


    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        assertEquals("A", rnaTranscription.transcribe("T"));
    }


    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        assertEquals("U", rnaTranscription.transcribe("A"));
    }


    @Test
    public void testRnaTranscription() {
        assertEquals("UGCACCAGAAUU", rnaTranscription.transcribe("ACGTGGTCTTAA"));
    }

    @Test
    public void shouldReturnExceptionWhenInvalidDNAIsGiven() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Invalid String");
        rnaTranscription.transcribe("KBV");

    }
}
