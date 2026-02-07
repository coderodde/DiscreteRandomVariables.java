package io.github.coderodde.prob.randomvariables.support;

import static io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution.binomial;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinomialDistributionTest {
    
    private static final BigDecimal p = BigDecimal.valueOf(0.3);
    private static final BigInteger n = BigInteger.valueOf(4);
    
    private final BinomialDistribution dist =
              new BinomialDistribution(n.longValue(), p.doubleValue());
    
    @Test
    public void getProbabilityMassBigInteger() {
        System.out.println(dist.getProbabilityMass(BigInteger.valueOf(2)));
    }
    
    @Test
    public void getProbabilityMassInt() {
        System.out.println(dist.getProbabilityMass(2));
    }

    @Test
    public void getSuccessProbability() {
        assertEquals(p, dist.getSuccessProbability());
    }
    
    @Test
    public void getFailureProbability() {
        assertEquals(BigDecimal.ONE.subtract(p), dist.getFailureProbability());
    }
    
    @Test
    public void testN() {
        assertEquals(BigInteger.valueOf(4), dist.n());
    }
    
    @Test
    public void binomialTest() {
        BigInteger n;
        BigInteger k;
        
        n = BigInteger.valueOf(7);
        k = BigInteger.valueOf(2);
        
        assertEquals(BigInteger.valueOf(21), binomial(n, k));
        
        k = BigInteger.valueOf(5);
        
        assertEquals(BigInteger.valueOf(21), binomial(n, k));
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void n() {
        new BinomialDistribution(BigInteger.ZERO, BigDecimal.valueOf(0.5));
    }
}
