package com.github.baniuk.ImageJTestSuite.matchers.arrays;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.closeTo;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;

/**
 * Factory class for Hamcrest array matchers.
 * 
 * @author p.baniukiewicz
 *
 */
public class ArrayMatchers {

  /**
   * Create matcher for comparing two double arrays with defined precision.
   * 
   * <p>Use {@link org.apache.commons.lang3.ArrayUtils#toObject(double[])} to produce Double[].
   * 
   * <pre>
   * <code>
   * Double[] a;
   * double[] b;
   * assertThat(a, arrayCloseTo(b, .2));
   * </code>
   * </pre>
   * 
   * @param array array to compare
   * @param error precision
   * @return matcher
   */
  public static Matcher<Double[]> arrayCloseTo(double[] array, double error) {
    List<Matcher<? super Double>> matchers = new ArrayList<Matcher<? super Double>>();
    for (double d : array) {
      matchers.add(closeTo(d, error));
    }
    return arrayContaining(matchers);
  }
}
