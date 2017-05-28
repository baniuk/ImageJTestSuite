package com.github.baniuk.ImageJTestSuite.matchers.file;

import java.io.File;

/**
 * Factory class for Hamcrest file matchers.
 * 
 * @author p.baniukiewicz
 *
 */
public class FileMatchers {

  /**
   * Deliver text file matcher that matches exact content of two files.
   * 
   * <pre>
   * <code>
   * assertThat(compared, containsExactText(expected);
   * </code>
   * </pre>
   * 
   * @param expected expected file
   * @return instance
   */
  public static FileMatcher containsExactText(File expected) {
    return new FileMatcher(expected);
  }

}
