package com.github.baniuk.ImageJTestSuite.matchers.json;

/**
 * @author p.baniukiewicz
 *
 */
public class JsonMatchers {

  /**
   * Compare two Json strings through their keys. Values are ignored.
   * 
   * <pre>
   * <code>
   * assertThat(compared, haveSameKeys(expected);
   * </code>
   * </pre>
   * 
   * @param expected json string that gives expected keys in json
   * @return instance
   */
  public static JsonKeysMatcher haveSameKeys(String expected) {
    return new JsonKeysMatcher(expected);
  }
}
