package StairsModules;

import java.math.BigDecimal;

public class Stairs
{
    private final BigDecimal height;
    private final BigDecimal maxHeightOfStep;

    public Stairs(BigDecimal height, BigDecimal maxHeightOfStep) {
        this.height = height;
        this.maxHeightOfStep = maxHeightOfStep;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public BigDecimal getMaxHeightOfStep() {
        return maxHeightOfStep;
    }

    @Override
    public String toString() {
        return "modules.Stairs{" +
                "height=" + height +
                ", maxHeightOfStep=" + maxHeightOfStep +
                '}';
    }
}