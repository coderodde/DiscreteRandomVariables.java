package io.github.coderodde.prob.randomvariables.support;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class GeometricDistributionTest {
    
    private final GeometricDistribution dist = 
              new GeometricDistribution(0.7);
    
    @Test
    public void getProbabilityMassBigInteger() {
        assertEquals(
                BigDecimal.valueOf(0.7), 
                dist.getProbabilityMass(BigInteger.ZERO));
        
        assertEquals(
                BigDecimal.valueOf(0.3 * 0.7), 
                dist.getProbabilityMass(BigInteger.ONE));
        
        assertEquals(
                BigDecimal.valueOf(0.3 * 0.3 * 0.7), 
                dist.getProbabilityMass(BigInteger.valueOf(2)));
        
        assertEquals(
                BigDecimal.valueOf(0.3 * 0.3 * 0.3 * 0.7), 
                dist.getProbabilityMass(BigInteger.valueOf(3)));
    }
    
    @Test
    public void getProbabilityMassInt() {
        assertEquals(
                BigDecimal.valueOf(0.7), 
                dist.getProbabilityMass(0));
        
        assertEquals(
                BigDecimal.valueOf(0.3 * 0.7), 
                dist.getProbabilityMass(1));
        
        assertEquals(
                BigDecimal.valueOf(0.3 * 0.3 * 0.7), 
                dist.getProbabilityMass(2));
        
        assertEquals(
                BigDecimal.valueOf(0.3 * 0.3 * 0.3 * 0.7), 
                dist.getProbabilityMass(3));
    }
    
    @Test
    public void getSuccessProbability() {
        assertEquals(BigDecimal.valueOf(0.7), dist.getSuccessProbability());
    }
    
    @Test
    public void getFailureProbability() {
        assertEquals(BigDecimal.valueOf(0.3), dist.getFailureProbability());
    }
}
