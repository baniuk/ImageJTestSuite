package com.github.baniuk.ImageJTestSuite.matchers.file;

import static com.github.baniuk.ImageJTestSuite.matchers.file.FileMatchers.containsExactText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;

import org.junit.Test;

/**
 * Test class for FileMatcher.
 * 
 * @author p.baniukiewicz
 *
 */
public class FileMatcherTest {

  /**
   * Test contains exact text different line.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_differentLine() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    File test = new File("src/test/resources/FileMatcherTest/differentLine.ijm");
    assertThat(test, is(not(containsExactText(orginal))));
  }

  /**
   * Test contains exact text same.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_same() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    File test = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    assertThat(test, containsExactText(orginal));
  }

  /**
   * Test contains exact text both empty.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_bothEmpty() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/empty.ijm");
    File test = new File("src/test/resources/FileMatcherTest/empty.ijm");
    assertThat(test, containsExactText(orginal));
  }

  /**
   * Test contains exact text orgshort.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_orgshort() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    File test = new File("src/test/resources/FileMatcherTest/shorter.ijm");
    assertThat(test, is(not(containsExactText(orginal))));
  }

  /**
   * Test contains exact text shortorg.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_shortorg() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    File test = new File("src/test/resources/FileMatcherTest/shorter.ijm");
    assertThat(orginal, is(not(containsExactText(test))));
  }

  /**
   * Test contains exact text empty.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_empty() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    File test = new File("src/test/resources/FileMatcherTest/empty.ijm");
    assertThat(orginal, is(not(containsExactText(test))));
  }

  /**
   * Test contains exact text empty 1.
   *
   * @throws Exception the exception
   */
  @Test
  public void testContainsExactText_empty1() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginal.ijm");
    File test = new File("src/test/resources/FileMatcherTest/empty.ijm");
    assertThat(test, is(not(containsExactText(orginal))));
  }

  /**
   * Test contains exact text no file.
   *
   * @throws Exception the exception
   */
  @Test(expected = IllegalArgumentException.class)
  public void testContainsExactText_noFile() throws Exception {
    File orginal = new File("src/test/resources/FileMatcherTest/orginallll.ijm");
    File test = new File("src/test/resources/FileMatcherTest/empty.ijm");
    assertThat(test, is(not(containsExactText(orginal))));
  }
}
