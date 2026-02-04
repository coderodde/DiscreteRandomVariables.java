package io.github.coderodde.prob.randomvariables.support;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class BernoulliDistributionTest {
    
    @Test
    public void testGetProbabilityMass() {
        BernoulliDistribution b =
                new BernoulliDistribution(BigDecimal.valueOf(0.6));
        
        assertEquals(
                BigDecimal.valueOf(0.6), 
                b.getProbabilityMass(BigInteger.ONE));
        
        assertEquals(
                BigDecimal.valueOf(0.4), 
                b.getProbabilityMass(BigInteger.ZERO));
    }
}
