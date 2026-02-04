package io.github.coderodde.prob.randomvariables.support;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class GeometricDistributionTest {
    
    private final GeometricDistribution dist = 
            new GeometricDistribution(BigDecimal.valueOf(0.7));
    
    @Test
    public void getProbabilityMass() {
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
}
