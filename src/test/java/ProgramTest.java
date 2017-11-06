import org.junit.Assert;
import org.junit.Test;
import serialization.Program;

public class ProgramTest {
    @Test
    public void generatingBlockReturnsBlock() {
        Assert.assertNotNull(Program.generateBlock());
    }

    @Test(expected = IllegalArgumentException.class)
    public void gettingPefromanceProcesNullArguments() {
        Program.getPerfomance(null, null);
    }
}
