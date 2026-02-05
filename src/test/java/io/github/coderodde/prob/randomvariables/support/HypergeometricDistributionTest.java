package io.github.coderodde.prob.randomvariables.support;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class HypergeometricDistributionTest {
    
    private static final BigInteger N = BigInteger.valueOf(10);
    private static final BigInteger K = BigInteger.valueOf(4);
    private static final BigInteger n = BigInteger.valueOf(3);
    
    private final HypergeometricDistribution dist = 
            new HypergeometricDistribution(N, K, n);
    
    @Test
    public void getProbabilityMass() {
        assertEquals(
                0.3, 
                dist.getProbabilityMass(BigInteger.valueOf(2)).doubleValue(), 
                0.01);
    }
}
