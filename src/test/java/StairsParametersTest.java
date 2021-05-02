import StairsModules.Stairs;
import StairsModules.StairsParameters;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StairsParametersTest {
    @Test
    public void StairsParametersTest()
    {
        Stairs[] stairs = {
                new Stairs(new BigDecimal("400.00"),
                           new BigDecimal("17.50")),
                new Stairs(new BigDecimal("500.00"),
                           new BigDecimal("22.48")),
                new Stairs(new BigDecimal("666.00"),
                           new BigDecimal("7.00"))
        };
        StairsParameters[] stairsParameters = {new StairsParameters(stairs[0]),
                                               new StairsParameters(stairs[1]),
                                               new StairsParameters(stairs[2])};

        assertTrue(stairsParameters[0].getStepsNumber().equals(new BigInteger("25")));
        assertTrue(stairsParameters[1].getStepsNumber().equals(new BigInteger("25")));
        assertTrue(stairsParameters[2].getStepsNumber().equals(new BigInteger("100")));
    }
}