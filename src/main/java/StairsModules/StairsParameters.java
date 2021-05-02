package StairsModules;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StairsParameters {
    private final Stairs stairs;
    private final BigInteger stepsNumber;
    private final BigDecimal stepHeight;

    public StairsParameters(Stairs stairs)
    {
        BigDecimal height = stairs.getHeight();
        BigDecimal stepHeight = stairs.getMaxHeightOfStep();

        while(height.remainder(stepHeight).equals(new BigDecimal("0.00"))==false)
        {
            stepHeight=stepHeight.subtract(new BigDecimal("0.01"));
        }

        this.stepsNumber= height.divide(stepHeight).toBigInteger();
        this.stepHeight=stepHeight;
        this.stairs=stairs;
    }

    public BigInteger getStepsNumber() {
        return stepsNumber;
    }

    public BigDecimal getStepHeight() {
        return stepHeight;
    }

    @Override
    public String toString() {
        return "modules.StairsParameters{" +
                "stairs=" + stairs +
                ", stepsNumber=" + stepsNumber +
                ", stepHeight=" + stepHeight +
                '}';
    }
}