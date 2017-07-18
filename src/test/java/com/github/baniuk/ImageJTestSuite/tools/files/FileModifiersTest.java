package com.github.baniuk.ImageJTestSuite.tools.files;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author p.baniukiewicz
 *
 */
public class FileModifiersTest {
  static final Logger LOGGER = LoggerFactory.getLogger(FileModifiersTest.class.getName());

  /**
   * Test of {@link FileModifiers#getLine(Path, int)}.
   * 
   * @throws Exception on error
   */
  @Test
  public void testGetLine() throws Exception {
    Path original = Paths.get("src/test/resources/FileMatcherTest/orginal.ijm");
    String line = FileModifiers.getLine(original, 12);
    String exp = "addBar(\"C1-talA_GFP_rnd_motility_FLU\",d,d1,\"E\");";
    assertThat(line, is(exp));
  }

  /**
   * Test of {@link FileModifiers#replaceLine(Path, int, String)}.
   * 
   * @throws Exception on error
   */
  @Test
  public void testReplaceLine() throws Exception {
    Path original = Paths.get("src/test/resources/FileMatcherTest/orginal.ijm");
    Path target = Paths.get(System.getProperty("java.io.tmpdir"), "original.ijm");
    Files.copy(original, target, StandardCopyOption.REPLACE_EXISTING);

    FileModifiers.replaceLine(target, 10, "hehe");
    assertThat(FileModifiers.getLine(target, 10), is("hehe"));
  }

}
