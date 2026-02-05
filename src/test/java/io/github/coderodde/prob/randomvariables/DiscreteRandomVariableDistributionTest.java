package io.github.coderodde.prob.randomvariables;

import static io.github.coderodde.prob.randomvariables.DiscreteRandomVariableDistribution.binomial;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiscreteRandomVariableDistributionTest {
    
    @Test(expected = IllegalArgumentException.class) 
    public void negativeK() {
        DiscreteRandomVariableDistribution.checkLowerBoundK(BigInteger.valueOf(-1));
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void tooLargeK() {
        DiscreteRandomVariableDistribution.checkUpperBound(BigInteger.valueOf(3), BigInteger.valueOf(2));
    }
    
    @Test
    public void goodK() {
        assertEquals(
                BigInteger.valueOf(2), 
                DiscreteRandomVariableDistribution
                        .checkUpperBound(
                                BigInteger.valueOf(2), 
                                BigInteger.valueOf(2)));;
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void successProbability0() {
        DiscreteRandomVariableDistribution
                .checkSuccessProbability(BigDecimal.ZERO);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void successProbability1() {
        DiscreteRandomVariableDistribution
                .checkSuccessProbability(BigDecimal.ONE);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void binomialThrowsOnNegativeN() {
        binomial(BigInteger.valueOf(-1L), BigInteger.ONE);
    }
    
    @Test
    public void binomial_0_1() {
        assertEquals(BigInteger.ZERO, 
                     binomial(BigInteger.ZERO, BigInteger.ONE));
    }
    
    @Test
    public void binomial_1_minus_1() {
        assertEquals(BigInteger.ZERO,
                     binomial(BigInteger.ONE, BigInteger.ONE.negate()));
    }
    
    @Test
    public void binomialZeroK() {
        assertEquals(BigInteger.ONE, binomial(BigInteger.ONE, BigInteger.ZERO));
    }
    
    @Test
    public void binomialNequalsK() {
        BigInteger a = BigInteger.ZERO;
        assertEquals(BigInteger.ONE, binomial(a, a));
    }
}
