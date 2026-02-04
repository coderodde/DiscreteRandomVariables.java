package io.github.coderodde.prob.randomvariables.support;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class BernoulliDistributionTest {
    
    private final BernoulliDistribution dist =
              new BernoulliDistribution(BigDecimal.valueOf(0.6));
    
    @Test
    public void testGetProbabilityMass() {
        
        assertEquals(
                BigDecimal.valueOf(0.6), 
                dist.getProbabilityMass(BigInteger.ONE));
        
        assertEquals(
                BigDecimal.valueOf(0.4), 
                dist.getProbabilityMass(BigInteger.ZERO));
    }
    
    @Test
    public void getSuccessProbability() {
        assertEquals(BigDecimal.valueOf(0.6), dist.getSuccessProbability());
    }
    
    @Test
    public void getFailureProbability() {
        assertEquals(BigDecimal.valueOf(0.4), dist.getFailureProbability());
    }
}
