package io.github.coderodde.prob.randomvariables.support;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class PoissonDistributionTest {
    
    private final PoissonDistribution dist = 
              new PoissonDistribution(1.631);
    
    @Test
    public void getProbabilityMassBigInteger() {
        assertEquals(
                0.1957,
                dist.getProbabilityMass(BigInteger.ZERO).doubleValue(),
                0.01);
        
        assertEquals(
                0.1416,
                dist.getProbabilityMass(BigInteger.valueOf(3)).doubleValue(), 
                0.01);
        
        assertEquals(
                0.0188,
                dist.getProbabilityMass(BigInteger.valueOf(5)).doubleValue(), 
                0.01);
    }
    
    @Test
    public void getProbabilityMassInt() {
        assertEquals(
                0.1957,
                dist.getProbabilityMass(0).doubleValue(),
                0.01);
        
        assertEquals(
                0.1416,
                dist.getProbabilityMass(3).doubleValue(), 
                0.01);
        
        assertEquals(
                0.0188,
                dist.getProbabilityMass(5).doubleValue(), 
                0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkLambda() {
        new PoissonDistribution(BigDecimal.ZERO);
    }
    
    @Test
    public void getLambda() {
        assertEquals(BigDecimal.valueOf(1.631), dist.getLambda());
    }
}
