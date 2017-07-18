package com.github.baniuk.ImageJTestSuite.tools.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Modify files or their parts.
 * 
 * @author p.baniukiewicz
 *
 */
public class FileModifiers {

  /**
   * Replace line in file.
   * 
   * @param name file name and path
   * @param lineNumber line number from 0
   * @param data replace string
   * @throws IOException error
   */
  public static void replaceLine(Path name, int lineNumber, String data) throws IOException {
    List<String> lines = Files.readAllLines(name, StandardCharsets.UTF_8);
    lines.set(lineNumber, data);
    Files.write(name, lines, StandardCharsets.UTF_8);
  }

  /**
   * Get line from file.
   * 
   * @param name file name and path
   * @param lineNumber line number from 0
   * @return Line at position lineNumber
   * @throws IOException error
   */
  public static String getLine(Path name, int lineNumber) throws IOException {
    List<String> lines = Files.readAllLines(name, StandardCharsets.UTF_8);
    return lines.get(lineNumber);
  }

}
